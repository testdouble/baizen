(ns baizen.formats.s-transaction-detail
  (:require [baizen.formats :refer [BaiFormat index-of drop-slash lookup-type-code]]))

(defrecord STransactionDetail [line]
  BaiFormat
  (fields [_]
    [:record-code :type-code :amount :funds-type
     :immediate-availability-amount :oneday-availability-amount :morethanoneday-availability-amount
     :bank-reference-number :customer-reference-number :text])

  (prepare [this line]
    (-> line
        (update-in [(index-of this :customer-reference-number)] drop-slash)
        (update-in [(index-of this :type-code)] lookup-type-code))))
