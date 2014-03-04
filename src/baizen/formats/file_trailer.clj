(ns baizen.formats.file-trailer
  (:require [baizen.formats :refer [BaiFormat index-of drop-slash]]))

(defrecord FileTrailer [line]
  BaiFormat
  (fields [_] [:record-code :file-control-total :number-of-groups :number-of-records])

  (prepare [this line]
    (update-in line [(index-of this :number-of-records)] drop-slash)))
