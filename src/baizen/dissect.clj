(ns baizen.dissect
  (:require [clojure.core.match :refer [match]]))

(defn dissect-line
  "dissect a BAI vector into a hash of understandable parts"
  [line]
  (match [line]
         [(["01" & r] :seq) ] {:record-name "File Header"}
         :else line))
