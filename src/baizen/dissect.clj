(ns baizen.dissect
  (:require [clojure.core.match :refer [match]]
            [baizen.formats.file-header :refer :all]))

(defn dissect-line
  "dissect a BAI vector into a hash of understandable parts"
  [line]
  (match [line]
         [(["01" & r] :seq) ] (file-header line)
         :else line))
