(ns baizen.core
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [baizen.dissect :refer [dissect-line]]))

(defn parse
  "parse a BAI file into a clojure.lang.LazySeq"
  [file]
  (with-open [file-reader (io/reader file)]
    (doall
     (map dissect-line (csv/read-csv file-reader)))))
