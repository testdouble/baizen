(ns baizen.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [baizen.continuations :as continuations]
            [baizen.parser :refer [parse-file-header parse-file-trailer parse-groups]]))

(defmulti parse
  "parse a BAI file into a Vector of Maps"
  class)

(defmethod parse
  java.lang.String
  [file-name]
  (parse (io/reader file-name)))

(defmethod parse
  java.io.Reader
  [reader]
  (with-open [rdr reader]
    (let [lines (csv/read-csv rdr)
          preprocessed (continuations/preprocess lines)
          header (first preprocessed)
          trailer (last preprocessed)]
      {:file-header (parse-file-header header)
       :groups (parse-groups (rest preprocessed))
       :file-trailer (parse-file-trailer trailer)})))
