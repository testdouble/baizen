(ns baizen.formats.account-identifier
  (:require [baizen.formats :refer [BaiFormat index-of drop-slash lookup-type-code]]))

(defn- hashify-summary-fields [line]
  (let [fields (subvec line 0 3)
        summary-field-keys [:type-code :amount :item-count :funds-type]
        summary-fields (partition 4 (subvec line 3))]
    (conj
      fields
      (map #(zipmap (cycle summary-field-keys) %) summary-fields))))

(defn- prepare-in-summaries [line key f]
  (assoc line 3 (map #(update-in % [key] f) (nth line 3))))

(defn- drop-all-slashes [line]
  (prepare-in-summaries line :funds-type drop-slash))

(defn- lookup-all-type-codes [line]
  (prepare-in-summaries line :type-code lookup-type-code))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-code :customer-account-number :currency-code :summaries])

  (prepare [this line]
    (let [line-with-summaries (hashify-summary-fields line)]
      (-> line-with-summaries
          drop-all-slashes
          lookup-all-type-codes))))
