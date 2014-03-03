(ns baizen.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [baizen.continuations :refer [preprocess]]
            [baizen.parser :refer [parse-file-header-info parse-file-trailer-info parse-groups]]))

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
          preprocessed (preprocess lines)
          header (first preprocessed)
          trailer (last preprocessed)]
      { :file-header (parse-file-header-info header)
        :groups (parse-groups (take-while
                                #(not (= (first %) "99"))
                                (rest preprocessed)))
        :file-trailer (parse-file-trailer-info trailer)})))
