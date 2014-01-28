(ns baizen.formats.account-identifier
  (:require [baizen.formats :refer :all]))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-code :customer-account-number :currency-code
               :type-code :amount :item-count :funds-type])

  (prepare [this line]
    (-> line
        (assoc (index-of this :funds-type) (drop-slash (get line (index-of this :funds-type)))))))
