(ns baizen.formats)

(defn ?assoc
  "only assoc if the value in the map is nil or the key doesn't exist"
  [m k v]
  (update-in m [k] #(or %1 %2) v))

(defprotocol BaiFormat
  "a clojure protocol for describing a BAI record format"
  (fields [f])
  (prepare [f line]))

(defn index-of [this key]
  (.indexOf (fields this) key))

(defn dissect [this]
  (let [line (prepare this (:line this))]
    (zipmap (fields this) line)))
