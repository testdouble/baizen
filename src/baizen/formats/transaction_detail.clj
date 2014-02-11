(ns baizen.formats.transaction-detail
  (:require [baizen.formats :refer :all]
            [baizen.utils :refer [drop-slash]]))

(defrecord TransactionDetail [line]
  BaiFormat
  (fields [_]
    [:record-code :type-code :amount :funds-type
     :bank-reference-number :customer-reference-number :text])

  (prepare [this line]
    (update-in line [(index-of this :customer-reference-number)] drop-slash)))
