(ns baizen.formats.account-identifier
  (:require [baizen.formats :refer :all]
            [baizen.utils :refer [drop-slash]]))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-code :customer-account-number :currency-code
               :type-code :amount :item-count :funds-type])

  (prepare [this line]
    (update-in line [(index-of this :funds-type)] drop-slash)))
