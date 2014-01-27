(ns baizen.formats.file-header)

(def
  ^{:private true}
  fields [:record-name :sender-id :receiver-id
          :creation-date :creation-time :file-id
          :record-length :block-size :version])

(defn- prepare [line]
  (assoc line
    (.indexOf fields :record-name) "File Header"
    (.indexOf fields :version) "2"))

(defn file-header
  "The file header marks the beginning of a file. It identifies the sender and the receiver of the transmission, and it describes the structure of the file. All fields are required except those labeled optional."
  [line]
  (let [line (prepare line)]

    (zipmap fields line)))
