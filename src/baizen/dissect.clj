(ns baizen.dissect
  (:require [clojure.core.match :refer [match]]))

(defn file-header
  ""
  [line]
  {:record-name "File Header"
   :sender-id (second line)
   :receiver-id (get line 2)
   :creation-date (get line 3)
   :creation-time (get line 4)
   :file-id (get line 5)
   :record-length (get line 6)
   :block-size (get line 7)
   :version "2"})

(defn dissect-line
  "dissect a BAI vector into a hash of understandable parts"
  [line]
  (match [line]
         [(["01" & r] :seq) ] (file-header line)
         :else line))
