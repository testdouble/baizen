(ns baizen.formats.account-identifier
  (:require [baizen.formats :refer :all]))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-name])

  (prepare [this line]
    (-> line
        (assoc (index-of this :record-name) "Account Identifier and Summary Status")))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))
