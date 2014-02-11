(ns baizen.formats.s-transaction-detail
  (:require [baizen.formats :refer :all]))

(defrecord STransactionDetail [line]
  BaiFormat
  (fields [_]
    [:record-code :type-code :amount :funds-type
     :immediate-availibility-amount :oneday-availibility-amount :morethanoneday-availibility-amount
     :bank-reference-number :customer-reference-number :text])

  (prepare [this line]
    (-> line
        (assoc (index-of this :customer-reference-number) (drop-slash (get line (index-of this :customer-reference-number)))))))
