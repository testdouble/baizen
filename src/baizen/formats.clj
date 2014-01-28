(ns baizen.formats)

(defn ?assoc [m k v]
  (assoc m k (or (get m k) v)))

(defprotocol BaiFormat
  "a clojure protocol for describing a BAI record format"
  (fields [f])
  (prepare [f line])
  (dissect [f]))

(defn index-of [this key]
  (.indexOf (fields this) key))
