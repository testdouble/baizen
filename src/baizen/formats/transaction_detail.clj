(ns baizen.formats.transaction-detail
  (:require [baizen.formats :refer :all]))

(defrecord TransactionDetail [line]
  BaiFormat
  (fields [_]
    (if (= "S" (get line 3))
      [:record-code :type-code :amount :funds-type
       :immediate-availibility-amount :oneday-availibility-amount :morethanoneday-availibility-amount
       :bank-reference-number :customer-reference-number :text]
      [:record-code :type-code :amount :funds-type
       :bank-reference-number :customer-reference-number :text]))

  (prepare [this line]
    (-> line
        (assoc (index-of this :customer-reference-number) (drop-slash (get line (index-of this :customer-reference-number)))))))
