(ns baizen.formats.group-trailer
  (:require [baizen.formats :refer [BaiFormat index-of drop-slash]]))

(defrecord GroupTrailer [line]
  BaiFormat
  (fields [_] [:record-code :group-control-total :number-of-accounts :number-of-records])

  (prepare [this line]
    (update-in line [(index-of this :number-of-records)] drop-slash)))
