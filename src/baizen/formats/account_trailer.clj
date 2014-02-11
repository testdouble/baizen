(ns baizen.formats.account-trailer
  (:require [baizen.formats :refer :all]
            [baizen.utils :refer [drop-slash]]))

(defrecord AccountTrailer [line]
  BaiFormat
  (fields [_] [:record-code :account-control-total :number-of-records])

  (prepare [this line]
    (update-in line [(index-of this :number-of-records)] drop-slash)))
