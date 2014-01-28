(ns baizen.formats.transaction-detail
  (:require [baizen.formats :refer :all]))

(defrecord TransactionDetail [line]
  BaiFormat
  (fields [_]
    [:record-code])

  (prepare [this line]
    line))
