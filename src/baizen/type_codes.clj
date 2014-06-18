(ns baizen.type-codes)

;; The below is a port of Appendix A from
;; http://www.bai.org/Libraries/Site-General-Downloads/Cash_Management_2005.sflb.ashx
;; into a clojure hash.

;;
;; UNIFORM BAI BALANCE REPORTING TYPE CODES AND TYPE CODE RANGES
;; Type codes are three-digit numbers used to identify the types of data reported.
;; Codes are either Status, Summary, or Detail. General usage rules are as
;; follows:
;;
;; Account Status: These codes describe the status of the account (for example,
;; ledger balance, available balance, and float position). Account Status type
;; codes may only be used in the 03 record and associated Continuation (88)
;; records. Status amounts may be positive or negative. Status type codes may not
;; be accompanied by an item count or a funds type distribution. Only one amount
;; for any status type code can remain on file for a given As-of- Date for a given
;; account.
;;
;; Activity Summary: These codes summarize account credit and debit activity (for
;; example, total lockbox credits or total security debits) and may only be used
;; in the 03 record and associated Continuation (88) records. Summary amounts are
;; always positive or unsigned. Summary type codes may be accompanied by an item
;; count or funds type distribution. Only one amount for any Summary type code can
;; remain on file for a given As-of-Date for a given account
;;
;; Transaction Detail: These codes detail individual credits and debits (for
;; example, individual lockbox deposit or foreign exchange debit) and may only be
;; used in the 16 record. Detail amounts are always positive or unsigned. An
;; account file may contain several transaction details with the same type code
;; for a given As-of-Date.
;;
;; Type Code Ranges
;; The following table indicates the ranges of three-digit numbers used for Status, Summary, and Detail type codes:
;;      Type Codes
;;    Description
;;      001–099
;;    Account Status type codes
;;      100
;;    Total Credits Summary type code
;;      101-399
;;    Credit Summary and Detail type codes
;;      400
;;    Total Debits Summary type codes
;;      401–699
;;    Debit summary and Detail type codes
;;      700–799
;;    Loan Summary and Detail type codes
;;      900–999

(def type-codes
  {
   ;; UNIFORM BAI BALANCE REPORTING TYPE CODES
   "010" {:transaction "NA" :level "Status" :description "Opening Ledger"}
   "011" {:transaction "NA" :level "Status" :description "Average Opening Ledger MTD"}
   "012" {:transaction "NA" :level "Status" :description "Average Opening Ledger YTD"}
   "015" {:transaction "NA" :level "Status" :description "Closing Ledger"}
   "020" {:transaction "NA" :level "Status" :description "Average Closing Ledger MTD"}
   "021" {:transaction "NA" :level "Status" :description "Average Closing Ledger – Previous Month"}
   "022" {:transaction "NA" :level "Status" :description "Aggregate Balance Adjustments"}
   "024" {:transaction "NA" :level "Status" :description "Average Closing Ledger YTD – Previous Month"}
   "025" {:transaction "NA" :level "Status" :description "Average Closing Ledger YTD"}
   "030" {:transaction "NA" :level "Status" :description "Current Ledger"}
   "037" {:transaction "NA" :level "Status" :description "ACH Net Position"}
   "039" {:transaction "NA" :level "Status" :description "Opening Available Total Same-Day ACH DTC Deposit"}
   "040" {:transaction "NA" :level "Status" :description "Opening Available"}
   "041" {:transaction "NA" :level "Status" :description "Average Opening Available MTD"}
   "042" {:transaction "NA" :level "Status" :description "Average Opening Available YTD"}
   "043" {:transaction "NA" :level "Status" :description "Average Available – Previous Month"}
   "044" {:transaction "NA" :level "Status" :description "Disbursing Opening Available Balance"}
   "045" {:transaction "NA" :level "Status" :description "Closing Available"}
   "050" {:transaction "NA" :level "Status" :description "Average Closing Available MTD"}
   "051" {:transaction "NA" :level "Status" :description "Average Closing Available – Last Month"}
   "054" {:transaction "NA" :level "Status" :description "Average Closing Available YTD – Last Month"}
   "055" {:transaction "NA" :level "Status" :description "Average Closing Available YTD"}
   "056" {:transaction "NA" :level "Status" :description "Loan Balance"}
   "057" {:transaction "NA" :level "Status" :description "Total Investment Position"}
   "059" {:transaction "NA" :level "Status" :description "Current Available (CRS Supressed)"}
   "060" {:transaction "NA" :level "Status" :description "Current Available"}
   "061" {:transaction "NA" :level "Status" :description "Average Current Available MTD"}
   "062" {:transaction "NA" :level "Status" :description "Average Current Available YTD"}
   "063" {:transaction "NA" :level "Status" :description "Total Float"}
   "065" {:transaction "NA" :level "Status" :description "Target Balance"}
   "066" {:transaction "NA" :level "Status" :description "Adjusted Balance"}
   "067" {:transaction "NA" :level "Status" :description "Adjusted Balance MTD"}
   "068" {:transaction "NA" :level "Status" :description "Adjusted Balance YTD"}
   "070" {:transaction "NA" :level "Status" :description "0-Day Float"}
   "072" {:transaction "NA" :level "Status" :description "1-Day Float"}
   "073" {:transaction "NA" :level "Status" :description "Float Adjustment"}
   "074" {:transaction "NA" :level "Status" :description "2 or More Days Float"}
   "075" {:transaction "NA" :level "Status" :description "3 or More Days Float"}
   "076" {:transaction "NA" :level "Status" :description "Adjustment to Balances"}
   "077" {:transaction "NA" :level "Status" :description "Average Adjustment to Balances MTD"}
   "078" {:transaction "NA" :level "Status" :description "Average Adjustment to Balances YTD"}
   "079" {:transaction "NA" :level "Status" :description "4-Day Float"}
   "080" {:transaction "NA" :level "Status" :description "5-Day Float"}
   "081" {:transaction "NA" :level "Status" :description "6-Day Float"}
   "082" {:transaction "NA" :level "Status" :description "Average 1-Day Float MTD"}
   "083" {:transaction "NA" :level "Status" :description "Average 1-Day Float YTD"}
   "084" {:transaction "NA" :level "Status" :description "Average 2-Day Float MTD"}
   "085" {:transaction "NA" :level "Status" :description "Average 2-Day Float YTD"}
   "086" {:transaction "NA" :level "Status" :description "Transfer Calculation"}
   
   ;; Summary and Detail Credits
   "100" {:transaction "CR" :level "Summary" :description "Total Credits"}
   "101" {:transaction "CR" :level "Summary" :description "Total Credit Amount MTD"}
   "105" {:transaction "CR" :level "Summary" :description "Credits Not Detailed"}
   "106" {:transaction "CR" :level "Summary" :description "Deposits Subject to Float"}
   "107" {:transaction "CR" :level "Summary" :description "Total Adjustment Credits YTD"}
   "108" {:transaction "CR" :level "Detail" :description "Credit (Any Type)"}
   "109" {:transaction "CR" :level "Summary" :description "Current Day Total Lockbox Deposits"}

   ;; Lockbox – Related Type Codes
   "110" {:transaction "CR" :level "Summary" :description "Total Lockbox Deposits"}
   "115" {:transaction "CR" :level "Detail" :description "Lockbox Deposit"}
   "116" {:transaction "CR" :level "Detail" :description "Item in Lockbox Deposit"}
   "118" {:transaction "CR" :level "Detail" :description "Lockbox Adjustment Credit"}
   "120" {:transaction "CR" :level "Summary" :description "EDI* Transaction Credit"}
   "121" {:transaction "CR" :level "Detail" :description "EDI Transaction Credit"}
   "122" {:transaction "CR" :level "Detail" :description "EDIBANX Credit Received"}
   "123" {:transaction "CR" :level "Detail" :description "EDIBANX Credit Return"}
   
   ;; Concentration – Related Type Codes
   "130" {:transaction "CR" :level "Summary" :description "Total Concentration Credits"}
   "131" {:transaction "CR" :level "Summary" :description "Total DTC Credits"}
   "135" {:transaction "CR" :level "Detail" :description "DTC Concentration Credit"}
   "136" {:transaction "CR" :level "Detail" :description "Item in DTC Deposit"}
   "140" {:transaction "CR" :level "Summary" :description "Total ACH Credits"}
   "142" {:transaction "CR" :level "Detail" :description "ACH Credit Received"}
   "143" {:transaction "CR" :level "Detail" :description "Item in ACH Deposit"}
   "145" {:transaction "CR" :level "Detail" :description "ACH Concentration Credit"}
   "146" {:transaction "CR" :level "Summary" :description "Total Bank Card Deposits"}
   "147" {:transaction "CR" :level "Detail" :description "Individual Bank Card Deposit"}
   
   ;; Preauthorized and ACH – Related Type Codes
   "150" {:transaction "CR" :level "Summary" :description "Total Preauthorized Payment Credits"}
   "155" {:transaction "CR" :level "Detail" :description "Preauthorized Draft Credit"}
   "156" {:transaction "CR" :level "Detail" :description "Item in PAC Deposit"}
   "160" {:transaction "CR" :level "Summary" :description "Total ACH Disbursing Funding Credits"}
   "162" {:transaction "CR" :level "Summary" :description "Corporate Trade Payment Settlement"}
   "163" {:transaction "CR" :level "Summary" :description "Corporate Trade Payment Credits"}
   "164" {:transaction "CR" :level "Detail" :description "Corporate Trade Payment Credit"}
   "165" {:transaction "CR" :level "Detail" :description "Preauthorized ACH Credit"}
   "166" {:transaction "CR" :level "Detail" :description "ACH Settlement"}
   "167" {:transaction "CR" :level "Summary" :description "ACH Settlement Credits"}
   "168" {:transaction "CR" :level "Detail" :description "ACH Return Item or Adjustment Settlement"}
   "169" {:transaction "CR" :level "Detail" :description "Miscellaneous ACH Credit"}
   
   ;; Other Deposits – Related Type Codes
   "170" {:transaction "CR" :level "Summary" :description "Total Other Check Deposits"}
   "171" {:transaction "CR" :level "Detail" :description "Individual Loan Deposit"}
   "172" {:transaction "CR" :level "Detail" :description "Deposit Correction"}
   "173" {:transaction "CR" :level "Detail" :description "Bank-Prepared Deposit"}
   "174" {:transaction "CR" :level "Detail" :description "Other Deposit"}
   "175" {:transaction "CR" :level "Detail" :description "Check Deposit Package"}
   "176" {:transaction "CR" :level "Detail" :description "Re-presented Check Deposit"}
   "178" {:transaction "CR" :level "Summary" :description "List Post Credits"}
   "180" {:transaction "CR" :level "Summary" :description "Total Loan Proceeds"}
   "182" {:transaction "CR" :level "Summary" :description "Total Bank-Prepared Deposits"}
   "184" {:transaction "CR" :level "Detail" :description "Draft Deposit"}
   "185" {:transaction "CR" :level "Summary" :description "Total Miscellaneous Deposits"}
   "186" {:transaction "CR" :level "Summary" :description "Total Cash Letter Credits"}
   "187" {:transaction "CR" :level "Detail" :description "Cash Letter Credit"}
   "188" {:transaction "CR" :level "Summary" :description "Total Cash Letter Adjustments"}
   "189" {:transaction "CR" :level "Detail" :description "Cash Letter Adjustment"}
   
   ;; Money Transfer – Related Type Codes
   "190" {:transaction "CR" :level "Summary" :description "Total Incoming Money Transfers"}
   "191" {:transaction "CR" :level "Detail" :description "Individual Incoming Internal Money Transfer"}
   "195" {:transaction "CR" :level "Detail" :description "Incoming Money Transfer"}
   "196" {:transaction "CR" :level "Detail" :description "Money Transfer Adjustment"}
   "198" {:transaction "CR" :level "Detail" :description "Compensation"}
   "200" {:transaction "CR" :level "Summary" :description "Total Automatic Transfer Credits"}
   "201" {:transaction "CR" :level "Detail" :description "Individual Automatic Transfer Credit"}
   "202" {:transaction "CR" :level "Detail" :description "Bond Operations Credit"}
   "205" {:transaction "CR" :level "Summary" :description "Total Book Transfer Credits"}
   "206" {:transaction "CR" :level "Detail" :description "Book Transfer Credit"}
   "207" {:transaction "CR" :level "Summary" :description "Total International Money Transfer Credits"}
   "208" {:transaction "CR" :level "Detail" :description "Individual International Money Transfer Credit"}
   "210" {:transaction "CR" :level "Summary" :description "Total International Credits"}
   "212" {:transaction "CR" :level "Detail" :description "Foreign Letter of Credit"}
   "213" {:transaction "CR" :level "Detail" :description "Letter of Credit"}
   "214" {:transaction "CR" :level "Detail" :description "Foreign Exchange of Credit"}
   "215" {:transaction "CR" :level "Summary" :description "Total Letters of Credit"}
   "216" {:transaction "CR" :level "Detail" :description "Foreign Remittance Credit"}
   "218" {:transaction "CR" :level "Detail" :description "Foreign Collection Credit"}
   "221" {:transaction "CR" :level "Detail" :description "Foreign Check Purchase"}
   "222" {:transaction "CR" :level "Detail" :description "Foreign Checks Deposited"}
   "224" {:transaction "CR" :level "Detail" :description "Commission"}
   "226" {:transaction "CR" :level "Detail" :description "International Money Market Trading"}
   "227" {:transaction "CR" :level "Detail" :description "Standing Order"}
   "229" {:transaction "CR" :level "Detail" :description "Miscellaneous International Credit"}

   ;; Security – Related Type Codes
   "230" {:transaction "CR" :level "Summary" :description "Total Security Credits"}
   "231" {:transaction "CR" :level "Summary" :description "Total Collection Credits"}
   "232" {:transaction "CR" :level "Detail" :description "Sale of Debt Security"}
   "233" {:transaction "CR" :level "Detail" :description "Securities Sold"}
   "234" {:transaction "CR" :level "Detail" :description "Sale of Equity Security"}
   "235" {:transaction "CR" :level "Detail" :description "Matured Reverse Repurchase Order"}
   "236" {:transaction "CR" :level "Detail" :description "Maturity of Debt Security"}
   "237" {:transaction "CR" :level "Detail" :description "Individual Collection Credit"}
   "238" {:transaction "CR" :level "Detail" :description "Collection of Dividends"}
   "239" {:transaction "CR" :level "Summary" :description "Total Bankers’ Acceptance Credits"}
   "240" {:transaction "CR" :level "Detail" :description "Coupon Collections – Banks"}
   "241" {:transaction "CR" :level "Detail" :description "Bankers’ Acceptances"}
   "242" {:transaction "CR" :level "Detail" :description "Collection of Interest Income"}
   "243" {:transaction "CR" :level "Detail" :description "Matured Fed Funds Purchased"}
   "244" {:transaction "CR" :level "Detail" :description "Interest/Matured Principal Payment"}
   "245" {:transaction "CR" :level "Summary" :description "Monthly Dividends"}
   "246" {:transaction "CR" :level "Detail" :description "Commercial Paper"}
   "247" {:transaction "CR" :level "Detail" :description "Capital Change"}
   "248" {:transaction "CR" :level "Detail" :description "Savings Bonds Sales Adjustment"}
   "249" {:transaction "CR" :level "Detail" :description "Miscellaneous Security Credit"}
   "250" {:transaction "CR" :level "Summary" :description "Total Checks Posted and Returned"}
   "251" {:transaction "CR" :level "Summary" :description "Total Debit Reversals"}
   "252" {:transaction "CR" :level "Detail" :description "Debit Reversal"}
   "254" {:transaction "CR" :level "Detail" :description "Posting Error Correction Credit"}
   "255" {:transaction "CR" :level "Detail" :description "Check Posted and Returned"}
   "256" {:transaction "CR" :level "Summary" :description "Total ACH Return Items"}
   "257" {:transaction "CR" :level "Detail" :description "Individual ACH Return Item"}
   "258" {:transaction "CR" :level "Detail" :description "ACH Reversal Credit"}
   "260" {:transaction "CR" :level "Summary" :description "Total Rejected Credits"}
   "261" {:transaction "CR" :level "Detail" :description "Individual Rejected Credit"}
   "263" {:transaction "CR" :level "Detail" :description "Overdraft"}
   "266" {:transaction "CR" :level "Detail" :description "Return Item"}
   "268" {:transaction "CR" :level "Detail" :description "Return Item Adjustment"}
   
   ;; ZBA and Disbursing – Related Type Codes
   "270" {:transaction "CR" :level "Summary" :description "Total ZBA Credits"}
   "271" {:transaction "CR" :level "Summary" :description "Net Zero-Balance Amount"}
   "274" {:transaction "CR" :level "Detail" :description "Cumulative** ZBA or Disbursement Credits"}
   "275" {:transaction "CR" :level "Detail" :description "ZBA Credit"}
   "276" {:transaction "CR" :level "Detail" :description "ZBA Float Adjustment"}
   "277" {:transaction "CR" :level "Detail" :description "ZBA Credit Transfer"}
   "278" {:transaction "CR" :level "Detail" :description "ZBA Credit Adjustment"}
   "280" {:transaction "CR" :level "Summary" :description "Total Controlled Disbursing Credits"}
   "281" {:transaction "CR" :level "Detail" :description "Individual Controlled Disbursing Credit"}
   "285" {:transaction "CR" :level "Summary" :description "Total DTC Disbursing Credits"}
   "286" {:transaction "CR" :level "Detail" :description "Individual DTC Disbursing Credit"}
   
   ;; Other (Expansion) Type Codes
   "294" {:transaction "CR" :level "Summary" :description "Total ATM Credits"}
   "295" {:transaction "CR" :level "Detail" :description "ATM Credit"}
   "301" {:transaction "CR" :level "Detail" :description "Commercial Deposit"}
   "302" {:transaction "CR" :level "Summary" :description "Correspondent Bank Deposit"}
   "303" {:transaction "CR" :level "Summary" :description "Total Wire Transfers In – FF"}
   "304" {:transaction "CR" :level "Summary" :description "Total Wire Transfers In – CHF"}
   "305" {:transaction "CR" :level "Summary" :description "Total Fed Funds Sold"}
   "306" {:transaction "CR" :level "Detail" :description "Fed Funds Sold"}
   "307" {:transaction "CR" :level "Summary" :description "Total Trust Credits"}
   "308" {:transaction "CR" :level "Detail" :description "Trust Credit"}
   "309" {:transaction "CR" :level "Summary" :description "Total Value - Dated Funds"}
   "310" {:transaction "CR" :level "Summary" :description "Total Commercial Deposits"}
   "315" {:transaction "CR" :level "Summary" :description "Total International Credits – FF"}
   "316" {:transaction "CR" :level "Summary" :description "Total International Credits – CHF"}
   "318" {:transaction "CR" :level "Summary" :description "Total Foreign Check Purchased"}
   "319" {:transaction "CR" :level "Summary" :description "Late Deposit"}
   "320" {:transaction "CR" :level "Summary" :description "Total Securities Sold – FF"}
   "321" {:transaction "CR" :level "Summary" :description "Total Securities Sold – CHF"}
   "324" {:transaction "CR" :level "Summary" :description "Total Securities Matured – FF"}
   "325" {:transaction "CR" :level "Summary" :description "Total Securities Matured – CHF"}
   "326" {:transaction "CR" :level "Summary" :description "Total Securities Interest"}
   "327" {:transaction "CR" :level "Summary" :description "Total Securities Matured"}
   "328" {:transaction "CR" :level "Summary" :description "Total Securities Interest – FF"}
   "329" {:transaction "CR" :level "Summary" :description "Total Securities Interest – CHF"}
   "330" {:transaction "CR" :level "Summary" :description "Total Escrow Credits"}
   "331" {:transaction "CR" :level "Detail" :description "Individual Escrow Credit"}
   "332" {:transaction "CR" :level "Summary" :description "Total Miscellaneous Securities Credits – FF"}
   "336" {:transaction "CR" :level "Summary" :description "Total Miscellaneous Securities Credits – CHF"}
   "338" {:transaction "CR" :level "Summary" :description "Total Securities Sold"}
   "340" {:transaction "CR" :level "Summary" :description "Total Broker Deposits"}
   "341" {:transaction "CR" :level "Summary" :description "Total Broker Deposits – FF"}
   "342" {:transaction "CR" :level "Detail" :description "Broker Deposit"}
   "343" {:transaction "CR" :level "Summary" :description "Total Broker Deposits – CHF"}
   "344" {:transaction "CR" :level "Detail" :description "Individual Back Value Credit"}
   "345" {:transaction "CR" :level "Detail" :description "Item in Brokers Deposit"}
   "346" {:transaction "CR" :level "Detail" :description "Sweep Interest Income"}
   "347" {:transaction "CR" :level "Detail" :description "Sweep Principal Sell"}
   "348" {:transaction "CR" :level "Detail" :description "Futures Credit"}
   "349" {:transaction "CR" :level "Detail" :description "Principal Payments Credit"}
   "350" {:transaction "CR" :level "Summary" :description "Investment Sold"}
   "351" {:transaction "CR" :level "Detail" :description "Individual Investment Sold"}
   "352" {:transaction "CR" :level "Summary" :description "Total Cash Center Credits"}
   "353" {:transaction "CR" :level "Detail" :description "Cash Center Credit"}
   "354" {:transaction "CR" :level "Detail" :description "Interest Credit"}
   "355" {:transaction "CR" :level "Summary" :description "Investment Interest"}
   "356" {:transaction "CR" :level "Summary" :description "Total Credit Adjustment"}
   "357" {:transaction "CR" :level "Detail" :description "Credit Adjustment"}
   "358" {:transaction "CR" :level "Detail" :description "YTD Adjustment Credit"}
   "359" {:transaction "CR" :level "Detail" :description "Interest Adjustment Credit"}
   "360" {:transaction "CR" :level "Summary" :description "Total Credits Less Wire Transfer and Returned Checks"}
   "361" {:transaction "CR" :level "Summary" :description "Grand Total Credits Less Grand Total Debits"}
   
   ;; Correspondent Bank and Federal Reserve – Related Type Codes
   "362" {:transaction "CR" :level "Detail" :description "Correspondent Collection"}
   "363" {:transaction "CR" :level "Detail" :description "Correspondent Collection Adjustment"}
   "364" {:transaction "CR" :level "Detail" :description "Loan Participation"}
   "366" {:transaction "CR" :level "Detail" :description "Currency and Coin Deposited"}
   "367" {:transaction "CR" :level "Detail" :description "Food Stamp Letter"}
   "368" {:transaction "CR" :level "Detail" :description "Food Stamp Adjustment"}
   "369" {:transaction "CR" :level "Detail" :description "Clearing Settlement Credit"}
   "370" {:transaction "CR" :level "Summary" :description "Total Back Value Credits"}
   "372" {:transaction "CR" :level "Detail" :description "Back Value Adjustment"}
   "373" {:transaction "CR" :level "Detail" :description "Customer Payroll"}
   "374" {:transaction "CR" :level "Detail" :description "FRB Statement Recap"}
   "376" {:transaction "CR" :level "Detail" :description "Savings Bond Letter or Adjustment"}
   "377" {:transaction "CR" :level "Detail" :description "Treasury Tax and Loan Credit"}
   "378" {:transaction "CR" :level "Detail" :description "Transfer of Treasury Credit"}
   "379" {:transaction "CR" :level "Detail" :description "FRB Government Checks Cash Letter Credit"}
   "381" {:transaction "CR" :level "Detail" :description "FRB Government Check Adjustment"}
   "382" {:transaction "CR" :level "Detail" :description "FRB Postal Money Order Credit"}
   "383" {:transaction "CR" :level "Detail" :description "FRB Postal Money Order Adjustment"}
   "384" {:transaction "CR" :level "Detail" :description "FRB Cash Letter Auto Charge Credit"}
   "385" {:transaction "CR" :level "Summary" :description "Total Universal Credits"}
   "386" {:transaction "CR" :level "Detail" :description "FRB Cash Letter Auto Charge Adjustment"}
   "387" {:transaction "CR" :level "Detail" :description "FRB Fine-Sort Cash Letter Credit"}
   "388" {:transaction "CR" :level "Detail" :description "FRB Fine-Sort Adjustment"}
   "389" {:transaction "CR" :level "Summary" :description "Total Freight Payment Credits"}
   
   ;; Miscellaneous Type Codes
   "390" {:transaction "CR" :level "Summary" :description "Total Miscellaneous Credits"}
   "391" {:transaction "CR" :level "Detail" :description "Universal Credit"}
   "392" {:transaction "CR" :level "Detail" :description "Freight Payment Credit"}
   "393" {:transaction "CR" :level "Detail" :description "Itemized Credit Over $10,000"}
   "394" {:transaction "CR" :level "Detail" :description "Cumulative** Credits"}
   "395" {:transaction "CR" :level "Detail" :description "Check Reversal"}
   "397" {:transaction "CR" :level "Detail" :description "Float Adjustment"}
   "398" {:transaction "CR" :level "Detail" :description "Miscellaneous Fee Refund"}
   "399" {:transaction "CR" :level "Detail" :description "Miscellaneous Credit"}
   
   ;; Summary and Detail Debits
   "400" {:transaction "DB" :level "Summary" :description "Total Debits"}
   "401" {:transaction "DB" :level "Summary" :description "Total Debit Amount MTD"}
   "403" {:transaction "DB" :level "Summary" :description "Today’s Total Debits"}
   "405" {:transaction "DB" :level "Summary" :description "Total Debit Less Wire Transfers and Charge- Backs"}
   "406" {:transaction "DB" :level "Summary" :description "Debits not Detailed"}
   "408" {:transaction "DB" :level "Detail" :description "Float Adjustment"}
   "409" {:transaction "DB" :level "Detail" :description "Debit (Any Type)"}
   "410" {:transaction "DB" :level "Summary" :description "Total YTD Adjustment"}
   "412" {:transaction "DB" :level "Summary" :description "Total Debits (Excluding Returned Items)"}
   
   ;; Lockbox Related – Type Codes
   "415" {:transaction "DB" :level "Detail" :description "Lockbox Debit"}
   "416" {:transaction "DB" :level "Summary" :description "Total Lockbox Debits"}
   "420" {:transaction "DB" :level "Summary" :description "EDI Transaction Debits"}
   "421" {:transaction "DB" :level "Detail" :description "EDI Transaction Debit"}
   "422" {:transaction "DB" :level "Detail" :description "EDIBANX Settlement Debit"}
   "423" {:transaction "DB" :level "Detail" :description "EDIBANX Return Item Debit"}
   
   ;; Payable-Through Draft – Related Type Codes
   "430" {:transaction "DB" :level "Summary" :description "Total Payable–Through Drafts"}
   "435" {:transaction "DB" :level "Detail" :description "Payable–Through Draft"}
   
   ;; ACH – Related Type Codes
   "445" {:transaction "DB" :level "Detail" :description "ACH Concentration Debit"}
   "446" {:transaction "DB" :level "Summary" :description "Total ACH Disbursement Funding Debits"}
   "447" {:transaction "DB" :level "Detail" :description "ACH Disbursement Funding Debit"}
   "450" {:transaction "DB" :level "Summary" :description "Total ACH Debits"}
   "451" {:transaction "DB" :level "Detail" :description "ACH Debit Received"}
   "452" {:transaction "DB" :level "Detail" :description "Item in ACH Disbursement or Debit"}
   "455" {:transaction "DB" :level "Detail" :description "Preauthorized ACH Debit"}
   "462" {:transaction "DB" :level "Detail" :description "Account Holder Initiated ACH Debit"}
   "463" {:transaction "DB" :level "Summary" :description "Corporate Trade Payment Debits"}
   "464" {:transaction "DB" :level "Detail" :description "Corporate Trade Payment Debit"}
   "465" {:transaction "DB" :level "Summary" :description "Corporate Trade Payment Settlement"}
   "466" {:transaction "DB" :level "Detail" :description "ACH Settlement"}
   "467" {:transaction "DB" :level "Summary" :description "ACH Settlement Debits"}
   "468" {:transaction "DB" :level "Detail" :description "ACH Return Item or Adjustment Settlement"}
   "469" {:transaction "DB" :level "Detail" :description "Miscellaneous ACH Debit"}
   
   ;; Checks Paid – Related Type Codes
   "470" {:transaction "DB" :level "Summary" :description "Total Check Paid"}
   "471" {:transaction "DB" :level "Summary" :description "Total Check Paid – Cumulative MTD"}
   "472" {:transaction "DB" :level "Detail" :description "Cumulative** Checks Paid"}
   "474" {:transaction "DB" :level "Detail" :description "Certified Check Debit"}
   "475" {:transaction "DB" :level "Detail" :description "Check Paid"}
   "476" {:transaction "DB" :level "Detail" :description "Federal Reserve Bank Letter Debit"}
   "477" {:transaction "DB" :level "Detail" :description "Bank Originated Debit"}
   "478" {:transaction "DB" :level "Summary" :description "List Post Debits"}
   "479" {:transaction "DB" :level "Detail" :description "List Post Debit"}
   "480" {:transaction "DB" :level "Summary" :description "Total Loan Payments"}
   "481" {:transaction "DB" :level "Detail" :description "Individual Loan Payment"}
   "482" {:transaction "DB" :level "Summary" :description "Total Bank-Originated Debits"}
   "484" {:transaction "DB" :level "Detail" :description "Draft"}
   "485" {:transaction "DB" :level "Detail" :description "DTC Debit"}
   "486" {:transaction "DB" :level "Summary" :description "Total Cash Letter Debits"}
   "487" {:transaction "DB" :level "Detail" :description "Cash Letter Debit"}
   "489" {:transaction "DB" :level "Detail" :description "Cash Letter Adjustment"}
   
   ;; Money Transfer – Related Type Codes
   "490" {:transaction "DB" :level "Summary" :description "Total Outgoing Money Transfers"}
   "491" {:transaction "DB" :level "Detail" :description "Individual Outgoing Internal Money Transfer"}
   "493" {:transaction "DB" :level "Detail" :description "Customer Terminal Initiated Money Transfer"}
   "495" {:transaction "DB" :level "Detail" :description "Outgoing Money Transfer"}
   "496" {:transaction "DB" :level "Detail" :description "Money Transfer Adjustment"}
   "498" {:transaction "DB" :level "Detail" :description "Compensation"}
   "500" {:transaction "DB" :level "Summary" :description "Total Automatic Transfer Debits"}
   "501" {:transaction "DB" :level "Detail" :description "Individual Automatic Transfer Debit"}
   "502" {:transaction "DB" :level "Detail" :description "Bond Operations Debit"}
   "505" {:transaction "DB" :level "Summary" :description "Total Book Transfer Debits"}
   "506" {:transaction "DB" :level "Detail" :description "Book Transfer Debit"}
   "507" {:transaction "DB" :level "Summary" :description "Total International Money Transfer Debits"}
   "508" {:transaction "DB" :level "Detail" :description "Individual International Money Transfer Debits"}
   "510" {:transaction "DB" :level "Summary" :description "Total International Debits"}
   "512" {:transaction "DB" :level "Detail" :description "Letter of Credit Debit"}
   "513" {:transaction "DB" :level "Detail" :description "Letter of Credit"}
   "514" {:transaction "DB" :level "Detail" :description "Foreign Exchange Debit"}
   "515" {:transaction "DB" :level "Summary" :description "Total Letters of Credit"}
   "516" {:transaction "DB" :level "Detail" :description "Foreign Remittance Debit"}
   "518" {:transaction "DB" :level "Detail" :description "Foreign Collection Debit"}
   "522" {:transaction "DB" :level "Detail" :description "Foreign Checks Paid"}
   "524" {:transaction "DB" :level "Detail" :description "Commission"}
   "526" {:transaction "DB" :level "Detail" :description "International Money Market Trading"}
   "527" {:transaction "DB" :level "Detail" :description "Standing Order"}
   "529" {:transaction "DB" :level "Detail" :description "Miscellaneous International Debit"}
   
   ;; Security – Related Type Codes
   "530" {:transaction "DB" :level "Summary" :description "Total Security Debits"}
   "531" {:transaction "DB" :level "Detail" :description "Securities Purchased"}
   "532" {:transaction "DB" :level "Summary" :description "Total Amount of Securities Purchased"}
   "533" {:transaction "DB" :level "Detail" :description "Security Collection Debit"}
   "534" {:transaction "DB" :level "Summary" :description "Total Miscellaneous Securities DB – FF"}
   "535" {:transaction "DB" :level "Detail" :description "Purchase of Equity Securities"}
   "536" {:transaction "DB" :level "Summary" :description "Total Miscellaneous Securities Debit – CHF"}
   "537" {:transaction "DB" :level "Summary" :description "Total Collection Debit"}
   "538" {:transaction "DB" :level "Detail" :description "Matured Repurchase Order"}
   "539" {:transaction "DB" :level "Summary" :description "Total Bankers’ Acceptances Debit"}
   "540" {:transaction "DB" :level "Detail" :description "Coupon Collection Debit"}
   "541" {:transaction "DB" :level "Detail" :description "Bankers’ Acceptances"}
   "542" {:transaction "DB" :level "Detail" :description "Purchase of Debt Securities"}
   "543" {:transaction "DB" :level "Detail" :description "Domestic Collection"}
   "544" {:transaction "DB" :level "Detail" :description "Interest/Matured Principal Payment"}
   "546" {:transaction "DB" :level "Detail" :description "Commercial paper"}
   "547" {:transaction "DB" :level "Detail" :description "Capital Change"}
   "548" {:transaction "DB" :level "Detail" :description "Savings Bonds Sales Adjustment"}
   "549" {:transaction "DB" :level "Detail" :description "Miscellaneous Security Debit"}
   
   ;; Deposited Items Returned – Related Type Codes
   "550" {:transaction "DB" :level "Summary" :description "Total Deposited Items Returned"}
   "551" {:transaction "DB" :level "Summary" :description "Total Credit Reversals"}
   "552" {:transaction "DB" :level "Detail" :description "Credit Reversal"}
   "554" {:transaction "DB" :level "Detail" :description "Posting Error Correction Debit"}
   "555" {:transaction "DB" :level "Detail" :description "Deposited Item Returned"}
   "556" {:transaction "DB" :level "Summary" :description "Total ACH Return Items"}
   "557" {:transaction "DB" :level "Detail" :description "Individual ACH Return Item"}
   "558" {:transaction "DB" :level "Detail" :description "ACH Reversal Debit"}
   "560" {:transaction "DB" :level "Summary" :description "Total Rejected Debits"}
   "561" {:transaction "DB" :level "Detail" :description "Individual Rejected Debit"}
   "563" {:transaction "DB" :level "Detail" :description "Overdraft"}
   "564" {:transaction "DB" :level "Detail" :description "Overdraft Fee"}
   "566" {:transaction "DB" :level "Detail" :description "Return Item"}
   "567" {:transaction "DB" :level "Detail" :description "Return Item Fee"}
   "568" {:transaction "DB" :level "Detail" :description "Return Item Adjustment"}
   
   ;; ZBA and Disbursing – Related Type Codes
   "570" {:transaction "DB" :level "Summary" :description "Total ZBA Debits"}
   "574" {:transaction "DB" :level "Detail" :description "Cumulative ZBA Debits"}
   "575" {:transaction "DB" :level "Detail" :description "ZBA Debit"}
   "577" {:transaction "DB" :level "Detail" :description "ZBA Debit Transfer"}
   "578" {:transaction "DB" :level "Detail" :description "ZBA Debit Adjustment"}
   "580" {:transaction "DB" :level "Summary" :description "Total Controlled Disbursing Debits"}
   "581" {:transaction "DB" :level "Detail" :description "Individual Controlled Disbursing Debit"}
   "583" {:transaction "DB" :level "Summary" :description "Total Disbursing Checks Paid – Early Amount"}
   "584" {:transaction "DB" :level "Summary" :description "Total Disbursing Checks Paid – Later Amount"}
   "585" {:transaction "DB" :level "Summary" :description "Disbursing Funding Requirement"}
   "586" {:transaction "DB" :level "Summary" :description "FRB Presentment Estimate (Fed Estimate)"}
   "587" {:transaction "DB" :level "Summary" :description "Late Debits (After Notification)"}
   "588" {:transaction "DB" :level "Summary" :description "Total Disbursing Checks Paid-Last Amount"}
   
   ;; Other (Expansion) Type Codes
   "590" {:transaction "DB" :level "Summary" :description "Total DTC Debits"}
   "594" {:transaction "DB" :level "Summary" :description "Total ATM Debits"}
   "595" {:transaction "DB" :level "Detail" :description "ATM Debit"}
   "596" {:transaction "DB" :level "Summary" :description "Total APR Debits"}
   "597" {:transaction "DB" :level "Detail" :description "ARP Debit"}
   "601" {:transaction "DB" :level "Summary" :description "Estimated Total Disbursement"}
   "602" {:transaction "DB" :level "Summary" :description "Adjusted Total Disbursement"}
   "610" {:transaction "DB" :level "Summary" :description "Total Funds Required"}
   "611" {:transaction "DB" :level "Summary" :description "Total Wire Transfers Out- CHF"}
   "612" {:transaction "DB" :level "Summary" :description "Total Wire Transfers Out – FF"}
   "613" {:transaction "DB" :level "Summary" :description "Total International Debit – CHF"}
   "614" {:transaction "DB" :level "Summary" :description "Total International Debit – FF"}
   "615" {:transaction "DB" :level "Summary" :description "Total Federal Reserve Bank – Commercial Bank Debit"}
   "616" {:transaction "DB" :level "Detail" :description "Federal Reserve Bank – Commercial Bank Debit"}
   "617" {:transaction "DB" :level "Summary" :description "Total Securities Purchased – CHF"}
   "618" {:transaction "DB" :level "Summary" :description "Total Securities Purchased – FF"}
   "621" {:transaction "DB" :level "Summary" :description "Total Broker Debits – CHF"}
   "622" {:transaction "DB" :level "Detail" :description "Broker Debit"}
   "623" {:transaction "DB" :level "Summary" :description "Total Broker Debits – FF"}
   "625" {:transaction "DB" :level "Summary" :description "Total Broker Debits"}
   "626" {:transaction "DB" :level "Summary" :description "Total Fed Funds Purchased"}
   "627" {:transaction "DB" :level "Detail" :description "Fed Funds Purchased"}
   "628" {:transaction "DB" :level "Summary" :description "Total Cash Center Debits"}
   "629" {:transaction "DB" :level "Detail" :description "Cash Center Debit"}
   "630" {:transaction "DB" :level "Summary" :description "Total Debit Adjustments"}
   "631" {:transaction "DB" :level "Detail" :description "Debit Adjustment"}
   "632" {:transaction "DB" :level "Summary" :description "Total Trust Debits"}
   "633" {:transaction "DB" :level "Detail" :description "Trust Debit"}
   "634" {:transaction "DB" :level "Detail" :description "YTD Adjustment Debit"}
   "640" {:transaction "DB" :level "Summary" :description "Total Escrow Debits"}
   "641" {:transaction "DB" :level "Detail" :description "Individual Escrow Debit"}
   "644" {:transaction "DB" :level "Detail" :description "Individual Back Value Debit"}
   "646" {:transaction "DB" :level "Summary" :description "Transfer Calculation Debit"}
   "650" {:transaction "DB" :level "Summary" :description "Investments Purchased"}
   "651" {:transaction "DB" :level "Detail" :description "Individual Investment purchased"}
   "654" {:transaction "DB" :level "Detail" :description "Interest Debit"}
   "655" {:transaction "DB" :level "Summary" :description "Total Investment Interest Debits"}
   "656" {:transaction "DB" :level "Detail" :description "Sweep Principal Buy"}
   "657" {:transaction "DB" :level "Detail" :description "Futures Debit"}
   "658" {:transaction "DB" :level "Detail" :description "Principal Payments Debit"}
   "659" {:transaction "DB" :level "Detail" :description "Interest Adjustment Debit"}
   
   ;; Correspondent Bank and Federal Reserve – Related Type Codes
   "661" {:transaction "DB" :level "Detail" :description "Account Analysis Fee"}
   "662" {:transaction "DB" :level "Detail" :description "Correspondent Collection Debit"}
   "663" {:transaction "DB" :level "Detail" :description "Correspondent Collection Adjustment"}
   "664" {:transaction "DB" :level "Detail" :description "Loan Participation"}
   "665" {:transaction "DB" :level "Summary" :description "Intercept Debits"}
   "666" {:transaction "DB" :level "Detail" :description "Currency and Coin Shipped"}
   "667" {:transaction "DB" :level "Detail" :description "Food Stamp Letter"}
   "668" {:transaction "DB" :level "Detail" :description "Food Stamp Adjustment"}
   "669" {:transaction "DB" :level "Detail" :description "Clearing Settlement Debit"}
   "670" {:transaction "DB" :level "Summary" :description "Total Back Value Debits"}
   "672" {:transaction "DB" :level "Detail" :description "Back Value Adjustment"}
   "673" {:transaction "DB" :level "Detail" :description "Customer Payroll"}
   "674" {:transaction "DB" :level "Detail" :description "FRB Statement Recap"}
   "676" {:transaction "DB" :level "Detail" :description "Savings Bond Letter or Adjustment"}
   "677" {:transaction "DB" :level "Detail" :description "Treasury Tax and Loan Debit"}
   "678" {:transaction "DB" :level "Detail" :description "Transfer of Treasury Debit"}
   "679" {:transaction "DB" :level "Detail" :description "FRB Government Checks Cash Letter Debit"}
   "681" {:transaction "DB" :level "Detail" :description "FRB Government Check Adjustment"}
   "682" {:transaction "DB" :level "Detail" :description "FRB Postal Money Order Debit"}
   "683" {:transaction "DB" :level "Detail" :description "FRB Postal Money Order Adjustment"}
   "684" {:transaction "DB" :level "Detail" :description "FRB Cash Letter Auto Charge Debit"}
   "685" {:transaction "DB" :level "Summary" :description "Total Universal Debits"}
   "686" {:transaction "DB" :level "Detail" :description "FRB Cash Letter Auto Charge Adjustment"}
   "687" {:transaction "DB" :level "Detail" :description "FRB Fine-Sort Cash Letter Debit"}
   "688" {:transaction "DB" :level "Detail" :description "FRB Fine-Sort Adjustment"}
   "689" {:transaction "DB" :level "Summary" :description "FRB Freight Payment Debits"}
   "690" {:transaction "DB" :level "Summary" :description "Total Miscellaneous Debits"}
   "691" {:transaction "DB" :level "Detail" :description "Universal Debit"}
   "692" {:transaction "DB" :level "Detail" :description "Freight Payment Debit"}
   "693" {:transaction "DB" :level "Detail" :description "Itemized Debit Over $10,000"}
   "694" {:transaction "DB" :level "Detail" :description "Deposit Reversal"}
   "695" {:transaction "DB" :level "Detail" :description "Deposit Correction Debit"}
   "696" {:transaction "DB" :level "Detail" :description "Regular Collection Debit"}
   "697" {:transaction "DB" :level "Detail" :description "Cumulative** Debits"}
   "698" {:transaction "DB" :level "Detail" :description "Miscellaneous Fees"}
   "699" {:transaction "DB" :level "Detail" :description "Miscellaneous Debit"}
   
   ;; Loan Transactions – Related Type Codes
   "701" {:transaction "NA" :level "Status" :description "Principal Loan Balance"}
   "703" {:transaction "NA" :level "Status" :description "Available Commitment Amount"}
   "705" {:transaction "NA" :level "Status" :description "Payment Amount Due"}
   "707" {:transaction "NA" :level "Status" :description "Principal Amount Past Due"}
   "709" {:transaction "NA" :level "Status" :description "Interest Amount Past Due"}
   "720" {:transaction "CR" :level "Summary" :description "Total Loan Payment"}
   "721" {:transaction "CR" :level "Detail" :description "Amount Applied to Interest"}
   "722" {:transaction "CR" :level "Detail" :description "Amount Applied to Principal"}
   "723" {:transaction "CR" :level "Detail" :description "Amount Applied to Escrow"}
   "724" {:transaction "CR" :level "Detail" :description "Amount Applied to Late Charges"}
   "725" {:transaction "CR" :level "Detail" :description "Amount Applied to Buydown"}
   "726" {:transaction "CR" :level "Detail" :description "Amount Applied to Misc. Fees"}
   "727" {:transaction "CR" :level "Detail" :description "Amount Applied to Deferred Interest Detail"}
   "728" {:transaction "CR" :level "Detail" :description "Amount Applied to Service Charge"}
   "760" {:transaction "DB" :level "Summary" :description "Loan Disbursement Non-Monetary Information"}
   
   ;; Non-Monetary Information
   "890" {:transaction "NA" :level "Detail" :description "Contains Non-monetary Information"}
   })
