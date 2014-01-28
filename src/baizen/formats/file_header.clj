(ns baizen.formats.file-header
  (:require [baizen.formats :refer :all]))

(defrecord FileHeader [line]
  BaiFormat
  (fields [_]
    [:record-code :sender-id :receiver-id
     :creation-date :creation-time :file-id
     :record-length :block-size :version])

  (prepare [this line]
    (-> line
        (assoc (index-of this :version) "2"))))
