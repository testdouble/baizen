(ns baizen.formats
  (:require [clojure.string :as str]
            [baizen.type-codes :refer [type-codes]]))

(defn ?assoc
  "Safe assoc. Only assoc if the value in the map is nil or the key does not exist."
  [m k v]
  (update-in m [k] #(or %1 %2) v))

(defn drop-slash [s]
  (when s
    (str/replace s #"\/$" "")))

(defn drop-trailing-whitespace [s]
  (when s
    (str/replace s #"\s*$" "")))

(defn lookup-type-code [type-code]
  (assoc (get type-codes type-code) :code type-code))

(defprotocol BaiFormat
  "A clojure protocol for describing a BAI record format."
  (fields [f])
  (prepare [f line]))

(defn index-of [this key]
  (.indexOf (fields this) key))

(defn dissect [this]
  (let [line (prepare this (:line this))]
    (zipmap (fields this) line)))
