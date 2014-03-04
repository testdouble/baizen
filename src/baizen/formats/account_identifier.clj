(ns baizen.formats.account-identifier
  (:require [baizen.formats :refer [BaiFormat drop-slash]]))

(defn hashify-summary-fields [line]
  (let [fields (subvec line 0 3)
        summary-field-keys [:type-code :amount :item-count :funds-type]
        summary-fields (partition 4 (subvec line 3))]
    (conj
      fields
      (map #(zipmap (cycle summary-field-keys) %) summary-fields))))

(defn drop-all-slashes [line]
  (assoc line 3 (map #(update-in % [:funds-type] drop-slash) (nth line 3))))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-code :customer-account-number :currency-code :summaries])

  (prepare [this line]
    (let [line-with-summaries (hashify-summary-fields line)]
      (drop-all-slashes line-with-summaries))))
