(ns baizen.core
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [clojure.core.match :refer [match]]))

(defn dissect-line
  "dissect a BAI vector into a hash of understandable parts"
  [line]
  (match [line]
         [(["01" & r] :seq) ] {:record-name "File Header"}
         :else line))

(defn parse
  "parse a BAI file into a clojure.lang.LazySeq"
  [file]
  (with-open [file-reader (io/reader file)]
    (doall
     (map dissect-line (csv/read-csv file-reader)))))
