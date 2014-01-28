(ns baizen.formats.group-header
  (:require [baizen.formats :refer :all]))

(defrecord GroupHeader [line]
  BaiFormat
  (fields [_]
    [:record-name :receiver-id :originator-id
     :group-status :as-of-date :as-of-time
     :currency-code :as-of-date-modifier])

  (index-of [this key]
    (.indexOf (fields this) key))

  (prepare [this line]
    (-> line
        (assoc (index-of this :record-name) "Group Header")
        (?assoc (index-of this :currency-code) "USD")
        (assoc (index-of this :as-of-date-modifier) (str (first (get line (index-of this :as-of-date-modifier)))))))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))
