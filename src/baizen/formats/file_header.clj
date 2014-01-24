(ns baizen.formats.file-header)

(defn file-header
  "The file header marks the beginning of a file."
  [line]
  {:record-name "File Header"
   :sender-id (second line)
   :receiver-id (get line 2)
   :creation-date (get line 3)
   :creation-time (get line 4)
   :file-id (get line 5)
   :record-length (get line 6)
   :block-size (get line 7)
   :version "2"})


