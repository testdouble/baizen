(ns baizen.formats.group-header
  (:require [baizen.formats :refer [BaiFormat ?assoc index-of drop-slash]]))

(defrecord GroupHeader [line]
  BaiFormat
  (fields [_]
    [:record-code :receiver-id :originator-id
     :group-status :as-of-date :as-of-time
     :currency-code :as-of-date-modifier])

  (prepare [this line]
    (-> line
        (?assoc (index-of this :currency-code) "USD")
        (assoc (index-of this :as-of-date-modifier) (drop-slash (get line (index-of this :as-of-date-modifier)))))))
