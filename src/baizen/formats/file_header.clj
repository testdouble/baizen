(ns baizen.formats.file-header
  (:require [baizen.formats :refer :all]))

(defrecord FileHeader [line]
  BaiFormat
  (fields [_]
    [:record-name :sender-id :receiver-id
     :creation-date :creation-time :file-id
     :record-length :block-size :version])

  (index-of [this key]
    (.indexOf (fields this) key))

  (prepare [this line]
    (assoc line
      (index-of this :record-name) "File Header"
      (index-of this :version) "2"))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))
