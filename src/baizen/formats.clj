(ns baizen.formats
  (:require [clojure.string :as str]))

(defn ?assoc [m k v]
  (assoc m k (or (get m k) v)))

(defn drop-slash [s]
  (when s
    (str/replace s #"\/$" "")))

(defprotocol BaiFormat
  "a clojure protocol for describing a BAI record format"
  (fields [f])
  (prepare [f line]))

(defn index-of [this key]
  (.indexOf (fields this) key))

(defn dissect [this]
  (let [line (prepare this (:line this))]
    (zipmap (fields this) line)))
