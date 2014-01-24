(ns baizen.formats.file-header)

(def fields [:record-name :sender-id :receiver-id
             :creation-date :creation-time :file-id
             :record-length :block-size :version])

(defn- prepare [line]
  (assoc line
    (.indexOf fields :record-name) "File Header"
    (.indexOf fields :version) "2"))

(defn file-header
  "The file header marks the beginning of a file."
  [line]
  (let [line (prepare line)]
    (zipmap fields line)))
