(ns baizen.dissect
  (:require [clojure.core.match :refer [match]]
            [baizen.formats :refer :all])
  (:import  [baizen.formats FileHeader GroupHeader AccountIdentifier]))

(defn dissect-line
  "dissect a BAI vector into a hash of understandable parts"
  [line]
  (match [line]
         [(["01" & r] :seq)] (dissect (FileHeader. line))
         [(["02" & r] :seq)] (dissect (GroupHeader. line))
         [(["03" & r] :seq)] (dissect (AccountIdentifier. line))
         :else line))
