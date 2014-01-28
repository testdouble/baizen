(ns baizen.formats.file-header
  (:require [baizen.formats :refer :all]))

(defrecord FileHeader [line]
  BaiFormat
  (fields [_]
    [:record-name :sender-id :receiver-id
     :creation-date :creation-time :file-id
     :record-length :block-size :version])

  (prepare [this line]
    (-> line
        (assoc (index-of this :record-name) "File Header")
        (assoc (index-of this :version) "2")))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))
