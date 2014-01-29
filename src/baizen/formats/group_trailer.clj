(ns baizen.formats.group-trailer
  (:require [baizen.formats :refer :all]))

(defrecord GroupTrailer [line]
  BaiFormat
  (fields [_] [:record-code :group-control-total :number-of-accounts :number-of-records])
  
  (prepare [this line]
    (-> line
        (assoc (index-of this :number-of-records) (drop-slash (get line (index-of this :number-of-records)))))))
