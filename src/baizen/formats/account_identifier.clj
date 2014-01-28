(ns baizen.formats.account-identifier
  (:require [baizen.formats :refer :all]))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-name :customer-account-number :currency-code
               :type-code :amount :item-count :funds-type])

  (prepare [this line]
    (-> line
        (assoc (index-of this :record-name) "Account Identifier and Summary Status")
        (assoc (index-of this :funds-type) (drop-slash (get line (index-of this :funds-type)))))))
