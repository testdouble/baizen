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

(def type-codes {
; UNIFORM BAI BALANCE REPORTING TYPE CODES
10 {:txn "NA" :level "Status" :description "Opening Ledger"}
11 {:txn "NA" :level "Status" :description "Average Opening Ledger MTD"}
12 {:txn "NA" :level "Status" :description "Average Opening Ledger YTD"}
15 {:txn "NA" :level "Status" :description "Closing Ledger"}
20 {:txn "NA" :level "Status" :description "Average Closing Ledger MTD"}
21 {:txn "NA" :level "Status" :description "Average Closing Ledger – Previous Month"}
22 {:txn "NA" :level "Status" :description "Aggregate Balance Adjustments"}
24 {:txn "NA" :level "Status" :description "Average Closing Ledger YTD – Previous Month"}
25 {:txn "NA" :level "Status" :description "Average Closing Ledger YTD"}
30 {:txn "NA" :level "Status" :description "Current Ledger"}
37 {:txn "NA" :level "Status" :description "ACH Net Position"}
39 {:txn "NA" :level "Status" :description "Opening Available Total Same-Day ACH DTC Deposit"}
40 {:txn "NA" :level "Status" :description "Opening Available"}
41 {:txn "NA" :level "Status" :description "Average Opening Available MTD"}
42 {:txn "NA" :level "Status" :description "Average Opening Available YTD"}
43 {:txn "NA" :level "Status" :description "Average Available – Previous Month"}
44 {:txn "NA" :level "Status" :description "Disbursing Opening Available Balance"}
45 {:txn "NA" :level "Status" :description "Closing Available"}
50 {:txn "NA" :level "Status" :description "Average Closing Available MTD"}
51 {:txn "NA" :level "Status" :description "Average Closing Available – Last Month"}
54 {:txn "NA" :level "Status" :description "Average Closing Available YTD – Last Month"}
55 {:txn "NA" :level "Status" :description "Average Closing Available YTD"}
56 {:txn "NA" :level "Status" :description "Loan Balance"}
57 {:txn "NA" :level "Status" :description "Total Investment Position"}
59 {:txn "NA" :level "Status" :description "Current Available (CRS Supressed)"}
60 {:txn "NA" :level "Status" :description "Current Available"}
61 {:txn "NA" :level "Status" :description "Average Current Available MTD"}
62 {:txn "NA" :level "Status" :description "Average Current Available YTD"}
63 {:txn "NA" :level "Status" :description "Total Float"}
65 {:txn "NA" :level "Status" :description "Target Balance"}
66 {:txn "NA" :level "Status" :description "Adjusted Balance"}
67 {:txn "NA" :level "Status" :description "Adjusted Balance MTD"}
68 {:txn "NA" :level "Status" :description "Adjusted Balance YTD"}
70 {:txn "NA" :level "Status" :description "0-Day Float"}
72 {:txn "NA" :level "Status" :description "1-Day Float"}
73 {:txn "NA" :level "Status" :description "Float Adjustment"}
74 {:txn "NA" :level "Status" :description "2 or More Days Float"}
75 {:txn "NA" :level "Status" :description "3 or More Days Float"}
76 {:txn "NA" :level "Status" :description "Adjustment to Balances"}
77 {:txn "NA" :level "Status" :description "Average Adjustment to Balances MTD"}
78 {:txn "NA" :level "Status" :description "Average Adjustment to Balances YTD"}
79 {:txn "NA" :level "Status" :description "4-Day Float"}
80 {:txn "NA" :level "Status" :description "5-Day Float"}
81 {:txn "NA" :level "Status" :description "6-Day Float"}
82 {:txn "NA" :level "Status" :description "Average 1-Day Float MTD"}
83 {:txn "NA" :level "Status" :description "Average 1-Day Float YTD"}
84 {:txn "NA" :level "Status" :description "Average 2-Day Float MTD"}
85 {:txn "NA" :level "Status" :description "Average 2-Day Float YTD"}
86 {:txn "NA" :level "Status" :description "Transfer Calculation"}


; Summary and Detail Credits
100 {:txn "CR" :level "Summary" :description "Total Credits"}
101 {:txn "CR" :level "Summary" :description "Total Credit Amount MTD"}
105 {:txn "CR" :level "Summary" :description "Credits Not Detailed"}
106 {:txn "CR" :level "Summary" :description "Deposits Subject to Float"}
107 {:txn "CR" :level "Summary" :description "Total Adjustment Credits YTD"}
108 {:txn "CR" :level "Detail" :description "Credit (Any Type)"}
109 {:txn "CR" :level "Summary" :description "Current Day Total Lockbox Deposits"}

; Lockbox – Related Type Codes
110 {:txn "CR" :level "Summary" :description "Total Lockbox Deposits"}
115 {:txn "CR" :level "Detail" :description "Lockbox Deposit"}
116 {:txn "CR" :level "Detail" :description "Item in Lockbox Deposit"}
118 {:txn "CR" :level "Detail" :description "Lockbox Adjustment Credit"}
120 {:txn "CR" :level "Summary" :description "EDI* Transaction Credit"}
121 {:txn "CR" :level "Detail" :description "EDI Transaction Credit"}
122 {:txn "CR" :level "Detail" :description "EDIBANX Credit Received"}
123 {:txn "CR" :level "Detail" :description "EDIBANX Credit Return"}

; Concentration – Related Type Codes Type Code Transaction Level
130 {:txn "CR" :level "Summary" :description "Total Concentration Credits"}
131 {:txn "CR" :level "Summary" :description "Total DTC Credits"}
135 {:txn "CR" :level "Detail" :description "DTC Concentration Credit"}
136 {:txn "CR" :level "Detail" :description "Item in DTC Deposit"}
140 {:txn "CR" :level "Summary" :description "Total ACH Credits"}
142 {:txn "CR" :level "Detail" :description "ACH Credit Received"}
143 {:txn "CR" :level "Detail" :description "Item in ACH Deposit"}
145 {:txn "CR" :level "Detail" :description "ACH Concentration Credit"}
146 {:txn "CR" :level "Summary" :description "Total Bank Card Deposits"}
147 {:txn "CR" :level "Detail" :description "Individual Bank Card Deposit"}

; Preauthorized and ACH – Related Type Codes
150 {:txn "CR" :level "Summary" :description "Total Preauthorized Payment Credits"}
155 {:txn "CR" :level "Detail" :description "Preauthorized Draft Credit"}
156 {:txn "CR" :level "Detail" :description "Item in PAC Deposit"}
160 {:txn "CR" :level "Summary" :description "Total ACH Disbursing Funding Credits"}
162 {:txn "CR" :level "Summary" :description "Corporate Trade Payment Settlement"}
163 {:txn "CR" :level "Summary" :description "Corporate Trade Payment Credits"}
164 {:txn "CR" :level "Detail" :description "Corporate Trade Payment Credit"}
165 {:txn "CR" :level "Detail" :description "Preauthorized ACH Credit"}
166 {:txn "CR" :level "Detail" :description "ACH Settlement"}
167 {:txn "CR" :level "Summary" :description "ACH Settlement Credits"}
168 {:txn "CR" :level "Detail" :description "ACH Return Item or Adjustment Settlement"}
169 {:txn "CR" :level "Detail" :description "Miscellaneous ACH Credit"}

; Other Deposits – Related Type Codes
170 {:txn "CR" :level "Summary" :description "Total Other Check Deposits"}
171 {:txn "CR" :level "Detail" :description "Individual Loan Deposit"}
172 {:txn "CR" :level "Detail" :description "Deposit Correction"}
173 {:txn "CR" :level "Detail" :description "Bank-Prepared Deposit"}
174 {:txn "CR" :level "Detail" :description "Other Deposit"}
175 {:txn "CR" :level "Detail" :description "Check Deposit Package"}
176 {:txn "CR" :level "Detail" :description "Re-presented Check Deposit"}
178 {:txn "CR" :level "Summary" :description "List Post Credits"}
180 {:txn "CR" :level "Summary" :description "Total Loan Proceeds"}

182 {:txn "CR" :level "Summary" :description "Total Bank-Prepared Deposits"}
184 {:txn "CR" :level "Detail" :description "Draft Deposit"}
185 {:txn "CR" :level "Summary" :description "Total Miscellaneous Deposits"}
186 {:txn "CR" :level "Summary" :description "Total Cash Letter Credits"}
187 {:txn "CR" :level "Detail" :description "Cash Letter Credit"}
188 {:txn "CR" :level "Summary" :description "Total Cash Letter Adjustments"}
189 {:txn "CR" :level "Detail" :description "Cash Letter Adjustment"}

; Money Transfer – Related Type Codes
190 {:txn "CR" :level "Summary" :description "Total Incoming Money Transfers"}
191 {:txn "CR" :level "Detail" :description "Individual Incoming Internal Money Transfer"}
195 {:txn "CR" :level "Detail" :description "Incoming Money Transfer"}
196 {:txn "CR" :level "Detail" :description "Money Transfer Adjustment"}
198 {:txn "CR" :level "Detail" :description "Compensation"}
200 {:txn "CR" :level "Summary" :description "Total Automatic Transfer Credits"}
201 {:txn "CR" :level "Detail" :description "Individual Automatic Transfer Credit"}
202 {:txn "CR" :level "Detail" :description "Bond Operations Credit"}
205 {:txn "CR" :level "Summary" :description "Total Book Transfer Credits"}
206 {:txn "CR" :level "Detail" :description "Book Transfer Credit"}
207 {:txn "CR" :level "Summary" :description "Total International Money Transfer Credits"}
208 {:txn "CR" :level "Detail" :description "Individual International Money Transfer Credit"}
210 {:txn "CR" :level "Summary" :description "Total International Credits"}
212 {:txn "CR" :level "Detail" :description "Foreign Letter of Credit"}
213 {:txn "CR" :level "Detail" :description "Letter of Credit"}

214 {:txn "CR" :level "Detail" :description "Foreign Exchange of Credit"}
215 {:txn "CR" :level "Summary" :description "Total Letters of Credit"}
216 {:txn "CR" :level "Detail" :description "Foreign Remittance Credit"}
218 {:txn "CR" :level "Detail" :description "Foreign Collection Credit"}
221 {:txn "CR" :level "Detail" :description "Foreign Check Purchase"}
222 {:txn "CR" :level "Detail" :description "Foreign Checks Deposited"}
224 {:txn "CR" :level "Detail" :description "Commission"}
226 {:txn "CR" :level "Detail" :description "International Money Market Trading"}
227 {:txn "CR" :level "Detail" :description "Standing Order"}
229 {:txn "CR" :level "Detail" :description "Miscellaneous International Credit"}

; Security – Related Type Codes
230 {:txn "CR" :level "Summary" :description "Total Security Credits"}
231 {:txn "CR" :level "Summary" :description "Total Collection Credits"}
232 {:txn "CR" :level "Detail" :description "Sale of Debt Security"}
233 {:txn "CR" :level "Detail" :description "Securities Sold"}
234 {:txn "CR" :level "Detail" :description "Sale of Equity Security"}
235 {:txn "CR" :level "Detail" :description "Matured Reverse Repurchase Order"}
236 {:txn "CR" :level "Detail" :description "Maturity of Debt Security"}
237 {:txn "CR" :level "Detail" :description "Individual Collection Credit"}
238 {:txn "CR" :level "Detail" :description "Collection of Dividends"}
239 {:txn "CR" :level "Summary" :description "Total Bankers’ Acceptance Credits"}
240 {:txn "CR" :level "Detail" :description "Coupon Collections – Banks"}
241 {:txn "CR" :level "Detail" :description "Bankers’ Acceptances"}
242 {:txn "CR" :level "Detail" :description "Collection of Interest Income"}
243 {:txn "CR" :level "Detail" :description "Matured Fed Funds Purchased"}
244 {:txn "CR" :level "Detail" :description "Interest/Matured Principal Payment"}
245 {:txn "CR" :level "Summary" :description "Monthly Dividends"}
246 {:txn "CR" :level "Detail" :description "Commercial Paper"}
247 {:txn "CR" :level "Detail" :description "Capital Change"}
248 {:txn "CR" :level "Detail" :description "Savings Bonds Sales Adjustment"}
249 {:txn "CR" :level "Detail" :description "Miscellaneous Security Credit"}
250 {:txn "CR" :level "Summary" :description "Total Checks Posted and Returned"}
251 {:txn "CR" :level "Summary" :description "Total Debit Reversals"}
252 {:txn "CR" :level "Detail" :description "Debit Reversal"}
254 {:txn "CR" :level "Detail" :description "Posting Error Correction Credit"}
255 {:txn "CR" :level "Detail" :description "Check Posted and Returned"}
256 {:txn "CR" :level "Summary" :description "Total ACH Return Items"}
257 {:txn "CR" :level "Detail" :description "Individual ACH Return Item"}
258 {:txn "CR" :level "Detail" :description "ACH Reversal Credit"}
260 {:txn "CR" :level "Summary" :description "Total Rejected Credits"}
261 {:txn "CR" :level "Detail" :description "Individual Rejected Credit"}
263 {:txn "CR" :level "Detail" :description "Overdraft"}
266 {:txn "CR" :level "Detail" :description "Return Item"}
268 {:txn "CR" :level "Detail" :description "Return Item Adjustment"}

; ZBA and Disbursing – Related Type Codes
270 {:txn "CR" :level "Summary" :description "Total ZBA Credits"}
271 {:txn "CR" :level "Summary" :description "Net Zero-Balance Amount"}
274 {:txn "CR" :level "Detail" :description "Cumulative** ZBA or Disbursement Credits"}
275 {:txn "CR" :level "Detail" :description "ZBA Credit"}
276 {:txn "CR" :level "Detail" :description "ZBA Float Adjustment"}
277 {:txn "CR" :level "Detail" :description "ZBA Credit Transfer"}
278 {:txn "CR" :level "Detail" :description "ZBA Credit Adjustment"}
280 {:txn "CR" :level "Summary" :description "Total Controlled Disbursing Credits"}
281 {:txn "CR" :level "Detail" :description "Individual Controlled Disbursing Credit"}
285 {:txn "CR" :level "Summary" :description "Total DTC Disbursing Credits"}
286 {:txn "CR" :level "Detail" :description "Individual DTC Disbursing Credit"}

; Other (Expansion) Type Codes
294 {:txn "CR" :level "Summary" :description "Total ATM Credits"}
295 {:txn "CR" :level "Detail" :description "ATM Credit"}
301 {:txn "CR" :level "Detail" :description "Commercial Deposit"}
302 {:txn "CR" :level "Summary" :description "Correspondent Bank Deposit"}
303 {:txn "CR" :level "Summary" :description "Total Wire Transfers In – FF"}
304 {:txn "CR" :level "Summary" :description "Total Wire Transfers In – CHF"}
305 {:txn "CR" :level "Summary" :description "Total Fed Funds Sold"}
306 {:txn "CR" :level "Detail" :description "Fed Funds Sold"}
307 {:txn "CR" :level "Summary" :description "Total Trust Credits"}
308 {:txn "CR" :level "Detail" :description "Trust Credit"}
309 {:txn "CR" :level "Summary" :description "Total Value - Dated Funds"}
310 {:txn "CR" :level "Summary" :description "Total Commercial Deposits"}
315 {:txn "CR" :level "Summary" :description "Total International Credits – FF"}
316 {:txn "CR" :level "Summary" :description "Total International Credits – CHF"}
318 {:txn "CR" :level "Summary" :description "Total Foreign Check Purchased"}
319 {:txn "CR" :level "Summary" :description "Late Deposit"}
320 {:txn "CR" :level "Summary" :description "Total Securities Sold – FF"}
321 {:txn "CR" :level "Summary" :description "Total Securities Sold – CHF"}
324 {:txn "CR" :level "Summary" :description "Total Securities Matured – FF"}
325 {:txn "CR" :level "Summary" :description "Total Securities Matured – CHF"}
326 {:txn "CR" :level "Summary" :description "Total Securities Interest"}
327 {:txn "CR" :level "Summary" :description "Total Securities Matured"}
328 {:txn "CR" :level "Summary" :description "Total Securities Interest – FF"}
329 {:txn "CR" :level "Summary" :description "Total Securities Interest – CHF"}
330 {:txn "CR" :level "Summary" :description "Total Escrow Credits"}
331 {:txn "CR" :level "Detail" :description "Individual Escrow Credit"}
332 {:txn "CR" :level "Summary" :description "Total Miscellaneous Securities Credits – FF"}
336 {:txn "CR" :level "Summary" :description "Total Miscellaneous Securities Credits – CHF"}
338 {:txn "CR" :level "Summary" :description "Total Securities Sold"}
340 {:txn "CR" :level "Summary" :description "Total Broker Deposits"}
341 {:txn "CR" :level "Summary" :description "Total Broker Deposits – FF"}
342 {:txn "CR" :level "Detail" :description "Broker Deposit"}
343 {:txn "CR" :level "Summary" :description "Total Broker Deposits – CHF"}
344 {:txn "CR" :level "Detail" :description "Individual Back Value Credit"}
345 {:txn "CR" :level "Detail" :description "Item in Brokers Deposit"}
346 {:txn "CR" :level "Detail" :description "Sweep Interest Income"}
347 {:txn "CR" :level "Detail" :description "Sweep Principal Sell"}
348 {:txn "CR" :level "Detail" :description "Futures Credit"}
349 {:txn "CR" :level "Detail" :description "Principal Payments Credit"}
350 {:txn "CR" :level "Summary" :description "Investment Sold"}
351 {:txn "CR" :level "Detail" :description "Individual Investment Sold"}
352 {:txn "CR" :level "Summary" :description "Total Cash Center Credits"}
353 {:txn "CR" :level "Detail" :description "Cash Center Credit"}
354 {:txn "CR" :level "Detail" :description "Interest Credit"}
355 {:txn "CR" :level "Summary" :description "Investment Interest"}
356 {:txn "CR" :level "Summary" :description "Total Credit Adjustment"}
357 {:txn "CR" :level "Detail" :description "Credit Adjustment"}
358 {:txn "CR" :level "Detail" :description "YTD Adjustment Credit"}
359 {:txn "CR" :level "Detail" :description "Interest Adjustment Credit"}
360 {:txn "CR" :level "Summary" :description "Total Credits Less Wire Transfer and Returned Checks"}
361 {:txn "CR" :level "Summary" :description "Grand Total Credits Less Grand Total Debits"}

; Correspondent Bank and Federal Reserve – Related Type Codes
362 {:txn "CR" :level "Detail" :description "Correspondent Collection"}
363 {:txn "CR" :level "Detail" :description "Correspondent Collection Adjustment"}
364 {:txn "CR" :level "Detail" :description "Loan Participation"}
366 {:txn "CR" :level "Detail" :description "Currency and Coin Deposited"}
367 {:txn "CR" :level "Detail" :description "Food Stamp Letter"}
368 {:txn "CR" :level "Detail" :description "Food Stamp Adjustment"}
369 {:txn "CR" :level "Detail" :description "Clearing Settlement Credit"}
370 {:txn "CR" :level "Summary" :description "Total Back Value Credits"}
372 {:txn "CR" :level "Detail" :description "Back Value Adjustment"}
373 {:txn "CR" :level "Detail" :description "Customer Payroll"}
374 {:txn "CR" :level "Detail" :description "FRB Statement Recap"}
376 {:txn "CR" :level "Detail" :description "Savings Bond Letter or Adjustment"}
377 {:txn "CR" :level "Detail" :description "Treasury Tax and Loan Credit"}
378 {:txn "CR" :level "Detail" :description "Transfer of Treasury Credit"}
379 {:txn "CR" :level "Detail" :description "FRB Government Checks Cash Letter Credit"}
381 {:txn "CR" :level "Detail" :description "FRB Government Check Adjustment"}
382 {:txn "CR" :level "Detail" :description "FRB Postal Money Order Credit"}
383 {:txn "CR" :level "Detail" :description "FRB Postal Money Order Adjustment"}
384 {:txn "CR" :level "Detail" :description "FRB Cash Letter Auto Charge Credit"}
385 {:txn "CR" :level "Summary" :description "Total Universal Credits"}
386 {:txn "CR" :level "Detail" :description "FRB Cash Letter Auto Charge Adjustment"}
387 {:txn "CR" :level "Detail" :description "FRB Fine-Sort Cash Letter Credit"}
388 {:txn "CR" :level "Detail" :description "FRB Fine-Sort Adjustment"}
389 {:txn "CR" :level "Summary" :description "Total Freight Payment Credits"}

; {:txn "Miscellaneous" :level "Type" :description "Codes"}
390 {:txn "CR" :level "Summary" :description "Total Miscellaneous Credits"}
391 {:txn "CR" :level "Detail" :description "Universal Credit"}
392 {:txn "CR" :level "Detail" :description "Freight Payment Credit"}
393 {:txn "CR" :level "Detail" :description "Itemized Credit Over $10,000"}
394 {:txn "CR" :level "Detail" :description "Cumulative** Credits"}
395 {:txn "CR" :level "Detail" :description "Check Reversal"}
397 {:txn "CR" :level "Detail" :description "Float Adjustment"}
398 {:txn "CR" :level "Detail" :description "Miscellaneous Fee Refund"}
399 {:txn "CR" :level "Detail" :description "Miscellaneous Credit"}

; Summary and Detail Debits
400 {:txn "DB" :level "Summary" :description "Total Debits"}
401 {:txn "DB" :level "Summary" :description "Total Debit Amount MTD"}
403 {:txn "DB" :level "Summary" :description "Today’s Total Debits"}
405 {:txn "DB" :level "Summary" :description "Total Debit Less Wire Transfers and Charge- Backs"}
406 {:txn "DB" :level "Summary" :description "Debits not Detailed"}
408 {:txn "DB" :level "Detail" :description "Float Adjustment"}
409 {:txn "DB" :level "Detail" :description "Debit (Any Type)"}
410 {:txn "DB" :level "Summary" :description "Total YTD Adjustment"}
412 {:txn "DB" :level "Summary" :description "Total Debits (Excluding Returned Items)"}

; {:txn "Lockbox" :level "Related" :description "– Type Codes"}
415 {:txn "DB" :level "Detail" :description "Lockbox Debit"}
416 {:txn "DB" :level "Summary" :description "Total Lockbox Debits"}
420 {:txn "DB" :level "Summary" :description "EDI Transaction Debits"}
421 {:txn "DB" :level "Detail" :description "EDI Transaction Debit"}
422 {:txn "DB" :level "Detail" :description "EDIBANX Settlement Debit"}
423 {:txn "DB" :level "Detail" :description "EDIBANX Return Item Debit"}

; Payable-Through Draft – Related Type Codes
430 {:txn "DB" :level "Summary" :description "Total Payable–Through Drafts"}
435 {:txn "DB" :level "Detail" :description "Payable–Through Draft"}

; {:txn "ACH" :level "–" :description "Related Type Codes"}
445 {:txn "DB" :level "Detail" :description "ACH Concentration Debit"}
446 {:txn "DB" :level "Summary" :description "Total ACH Disbursement Funding Debits"}
447 {:txn "DB" :level "Detail" :description "ACH Disbursement Funding Debit"}
450 {:txn "DB" :level "Summary" :description "Total ACH Debits"}
451 {:txn "DB" :level "Detail" :description "ACH Debit Received"}
452 {:txn "DB" :level "Detail" :description "Item in ACH Disbursement or Debit"}
455 {:txn "DB" :level "Detail" :description "Preauthorized ACH Debit"}
462 {:txn "DB" :level "Detail" :description "Account Holder Initiated ACH Debit"}
463 {:txn "DB" :level "Summary" :description "Corporate Trade Payment Debits"}
464 {:txn "DB" :level "Detail" :description "Corporate Trade Payment Debit"}
465 {:txn "DB" :level "Summary" :description "Corporate Trade Payment Settlement"}
466 {:txn "DB" :level "Detail" :description "ACH Settlement"}
467 {:txn "DB" :level "Summary" :description "ACH Settlement Debits"}
468 {:txn "DB" :level "Detail" :description "ACH Return Item or Adjustment Settlement"}
469 {:txn "DB" :level "Detail" :description "Miscellaneous ACH Debit"}

; {:txn "Checks" :level "Paid" :description "– Related Type Codes"}
470 {:txn "DB" :level "Summary" :description "Total Check Paid"}
471 {:txn "DB" :level "Summary" :description "Total Check Paid – Cumulative MTD"}
472 {:txn "DB" :level "Detail" :description "Cumulative** Checks Paid"}
474 {:txn "DB" :level "Detail" :description "Certified Check Debit"}
475 {:txn "DB" :level "Detail" :description "Check Paid"}
476 {:txn "DB" :level "Detail" :description "Federal Reserve Bank Letter Debit"}
477 {:txn "DB" :level "Detail" :description "Bank Originated Debit"}
478 {:txn "DB" :level "Summary" :description "List Post Debits"}
479 {:txn "DB" :level "Detail" :description "List Post Debit"}
480 {:txn "DB" :level "Summary" :description "Total Loan Payments"}
481 {:txn "DB" :level "Detail" :description "Individual Loan Payment"}
482 {:txn "DB" :level "Summary" :description "Total Bank-Originated Debits"}
484 {:txn "DB" :level "Detail" :description "Draft"}
485 {:txn "DB" :level "Detail" :description "DTC Debit"}
486 {:txn "DB" :level "Summary" :description "Total Cash Letter Debits"}
487 {:txn "DB" :level "Detail" :description "Cash Letter Debit"}
489 {:txn "DB" :level "Detail" :description "Cash Letter Adjustment"}

; {:txn "Money" :level "Transfer" :description "– Related Type Codes"}
490 {:txn "DB" :level "Summary" :description "Total Outgoing Money Transfers"}
491 {:txn "DB" :level "Detail" :description "Individual Outgoing Internal Money Transfer"}
493 {:txn "DB" :level "Detail" :description "Customer Terminal Initiated Money Transfer"}
495 {:txn "DB" :level "Detail" :description "Outgoing Money Transfer"}
496 {:txn "DB" :level "Detail" :description "Money Transfer Adjustment"}
498 {:txn "DB" :level "Detail" :description "Compensation"}
500 {:txn "DB" :level "Summary" :description "Total Automatic Transfer Debits"}
501 {:txn "DB" :level "Detail" :description "Individual Automatic Transfer Debit"}
502 {:txn "DB" :level "Detail" :description "Bond Operations Debit"}
505 {:txn "DB" :level "Summary" :description "Total Book Transfer Debits"}
506 {:txn "DB" :level "Detail" :description "Book Transfer Debit"}
507 {:txn "DB" :level "Summary" :description "Total International Money Transfer Debits"}
508 {:txn "DB" :level "Detail" :description "Individual International Money Transfer Debits"}
510 {:txn "DB" :level "Summary" :description "Total International Debits"}
512 {:txn "DB" :level "Detail" :description "Letter of Credit Debit"}
513 {:txn "DB" :level "Detail" :description "Letter of Credit"}
514 {:txn "DB" :level "Detail" :description "Foreign Exchange Debit"}
515 {:txn "DB" :level "Summary" :description "Total Letters of Credit"}
516 {:txn "DB" :level "Detail" :description "Foreign Remittance Debit"}
518 {:txn "DB" :level "Detail" :description "Foreign Collection Debit"}
522 {:txn "DB" :level "Detail" :description "Foreign Checks Paid"}
524 {:txn "DB" :level "Detail" :description "Commission"}
526 {:txn "DB" :level "Detail" :description "International Money Market Trading"}
527 {:txn "DB" :level "Detail" :description "Standing Order"}
529 {:txn "DB" :level "Detail" :description "Miscellaneous International Debit"}

; {:txn "Security" :level "–" :description "Related Type Codes"}
530 {:txn "DB" :level "Summary" :description "Total Security Debits"}
531 {:txn "DB" :level "Detail" :description "Securities Purchased"}
532 {:txn "DB" :level "Summary" :description "Total Amount of Securities Purchased"}
533 {:txn "DB" :level "Detail" :description "Security Collection Debit"}
534 {:txn "DB" :level "Summary" :description "Total Miscellaneous Securities DB – FF"}
535 {:txn "DB" :level "Detail" :description "Purchase of Equity Securities"}
536 {:txn "DB" :level "Summary" :description "Total Miscellaneous Securities Debit – CHF"}
537 {:txn "DB" :level "Summary" :description "Total Collection Debit"}
538 {:txn "DB" :level "Detail" :description "Matured Repurchase Order"}
539 {:txn "DB" :level "Summary" :description "Total Bankers’ Acceptances Debit"}
540 {:txn "DB" :level "Detail" :description "Coupon Collection Debit"}
541 {:txn "DB" :level "Detail" :description "Bankers’ Acceptances"}
542 {:txn "DB" :level "Detail" :description "Purchase of Debt Securities"}
543 {:txn "DB" :level "Detail" :description "Domestic Collection"}
544 {:txn "DB" :level "Detail" :description "Interest/Matured Principal Payment"}
546 {:txn "DB" :level "Detail" :description "Commercial paper"}
547 {:txn "DB" :level "Detail" :description "Capital Change"}
548 {:txn "DB" :level "Detail" :description "Savings Bonds Sales Adjustment"}
549 {:txn "DB" :level "Detail" :description "Miscellaneous Security Debit"}

; {:txn "Deposited" :level "Items" :description "Returned – Related Type Codes"}
550 {:txn "DB" :level "Summary" :description "Total Deposited Items Returned"}
551 {:txn "DB" :level "Summary" :description "Total Credit Reversals"}
552 {:txn "DB" :level "Detail" :description "Credit Reversal"}
554 {:txn "DB" :level "Detail" :description "Posting Error Correction Debit"}
555 {:txn "DB" :level "Detail" :description "Deposited Item Returned"}
556 {:txn "DB" :level "Summary" :description "Total ACH Return Items"}
557 {:txn "DB" :level "Detail" :description "Individual ACH Return Item"}
558 {:txn "DB" :level "Detail" :description "ACH Reversal Debit"}
560 {:txn "DB" :level "Summary" :description "Total Rejected Debits"}
561 {:txn "DB" :level "Detail" :description "Individual Rejected Debit"}
563 {:txn "DB" :level "Detail" :description "Overdraft"}
564 {:txn "DB" :level "Detail" :description "Overdraft Fee"}
566 {:txn "DB" :level "Detail" :description "Return Item"}
567 {:txn "DB" :level "Detail" :description "Return Item Fee"}
568 {:txn "DB" :level "Detail" :description "Return Item Adjustment"}

; {:txn "ZBA" :level "and" :description "Disbursing – Related Type Codes"}
570 {:txn "DB" :level "Summary" :description "Total ZBA Debits"}
574 {:txn "DB" :level "Detail" :description "Cumulative ZBA Debits"}
575 {:txn "DB" :level "Detail" :description "ZBA Debit"}
577 {:txn "DB" :level "Detail" :description "ZBA Debit Transfer"}
578 {:txn "DB" :level "Detail" :description "ZBA Debit Adjustment"}
580 {:txn "DB" :level "Summary" :description "Total Controlled Disbursing Debits"}
581 {:txn "DB" :level "Detail" :description "Individual Controlled Disbursing Debit"}
583 {:txn "DB" :level "Summary" :description "Total Disbursing Checks Paid – Early Amount"}
584 {:txn "DB" :level "Summary" :description "Total Disbursing Checks Paid – Later Amount"}
585 {:txn "DB" :level "Summary" :description "Disbursing Funding Requirement"}
586 {:txn "DB" :level "Summary" :description "FRB Presentment Estimate (Fed Estimate)"}
587 {:txn "DB" :level "Summary" :description "Late Debits (After Notification)"}
588 {:txn "DB" :level "Summary" :description "Total Disbursing Checks Paid-Last Amount"}

; {:txn "Other" :level "(":description "Expansion) Type Codes"}
590 {:txn "DB" :level "Summary" :description "Total DTC Debits"}
594 {:txn "DB" :level "Summary" :description "Total ATM Debits"}
595 {:txn "DB" :level "Detail" :description "ATM Debit"}
596 {:txn "DB" :level "Summary" :description "Total APR Debits"}
597 {:txn "DB" :level "Detail" :description "ARP Debit"}
601 {:txn "DB" :level "Summary" :description "Estimated Total Disbursement"}
602 {:txn "DB" :level "Summary" :description "Adjusted Total Disbursement"}
610 {:txn "DB" :level "Summary" :description "Total Funds Required"}
611 {:txn "DB" :level "Summary" :description "Total Wire Transfers Out- CHF"}
612 {:txn "DB" :level "Summary" :description "Total Wire Transfers Out – FF"}
613 {:txn "DB" :level "Summary" :description "Total International Debit – CHF"}
614 {:txn "DB" :level "Summary" :description "Total International Debit – FF"}
615 {:txn "DB" :level "Summary" :description "Total Federal Reserve Bank – Commercial Bank Debit"}
616 {:txn "DB" :level "Detail" :description "Federal Reserve Bank – Commercial Bank Debit"}
617 {:txn "DB" :level "Summary" :description "Total Securities Purchased – CHF"}
618 {:txn "DB" :level "Summary" :description "Total Securities Purchased – FF"}
621 {:txn "DB" :level "Summary" :description "Total Broker Debits – CHF"}
622 {:txn "DB" :level "Detail" :description "Broker Debit"}
623 {:txn "DB" :level "Summary" :description "Total Broker Debits – FF"}
625 {:txn "DB" :level "Summary" :description "Total Broker Debits"}
626 {:txn "DB" :level "Summary" :description "Total Fed Funds Purchased"}
627 {:txn "DB" :level "Detail" :description "Fed Funds Purchased"}
628 {:txn "DB" :level "Summary" :description "Total Cash Center Debits"}
629 {:txn "DB" :level "Detail" :description "Cash Center Debit"}
630 {:txn "DB" :level "Summary" :description "Total Debit Adjustments"}
631 {:txn "DB" :level "Detail" :description "Debit Adjustment"}
632 {:txn "DB" :level "Summary" :description "Total Trust Debits"}
633 {:txn "DB" :level "Detail" :description "Trust Debit"}
634 {:txn "DB" :level "Detail" :description "YTD Adjustment Debit"}
640 {:txn "DB" :level "Summary" :description "Total Escrow Debits"}
641 {:txn "DB" :level "Detail" :description "Individual Escrow Debit"}
644 {:txn "DB" :level "Detail" :description "Individual Back Value Debit"}
646 {:txn "DB" :level "Summary" :description "Transfer Calculation Debit"}
650 {:txn "DB" :level "Summary" :description "Investments Purchased"}
651 {:txn "DB" :level "Detail" :description "Individual Investment purchased"}
654 {:txn "DB" :level "Detail" :description "Interest Debit"}
655 {:txn "DB" :level "Summary" :description "Total Investment Interest Debits"}
656 {:txn "DB" :level "Detail" :description "Sweep Principal Buy"}
657 {:txn "DB" :level "Detail" :description "Futures Debit"}
658 {:txn "DB" :level "Detail" :description "Principal Payments Debit"}
659 {:txn "DB" :level "Detail" :description "Interest Adjustment Debit"}

; {:txn "Correspondent" :level "Bank" :description "and Federal Reserve – Related Type Codes"}
661 {:txn "DB" :level "Detail" :description "Account Analysis Fee"}
662 {:txn "DB" :level "Detail" :description "Correspondent Collection Debit"}
663 {:txn "DB" :level "Detail" :description "Correspondent Collection Adjustment"}
664 {:txn "DB" :level "Detail" :description "Loan Participation"}
665 {:txn "DB" :level "Summary" :description "Intercept Debits"}
666 {:txn "DB" :level "Detail" :description "Currency and Coin Shipped"}
667 {:txn "DB" :level "Detail" :description "Food Stamp Letter"}
668 {:txn "DB" :level "Detail" :description "Food Stamp Adjustment"}
669 {:txn "DB" :level "Detail" :description "Clearing Settlement Debit"}
670 {:txn "DB" :level "Summary" :description "Total Back Value Debits"}
672 {:txn "DB" :level "Detail" :description "Back Value Adjustment"}
673 {:txn "DB" :level "Detail" :description "Customer Payroll"}
674 {:txn "DB" :level "Detail" :description "FRB Statement Recap"}
676 {:txn "DB" :level "Detail" :description "Savings Bond Letter or Adjustment"}

677 {:txn "DB" :level "Detail" :description "Treasury Tax and Loan Debit"}
678 {:txn "DB" :level "Detail" :description "Transfer of Treasury Debit"}
679 {:txn "DB" :level "Detail" :description "FRB Government Checks Cash Letter Debit"}
681 {:txn "DB" :level "Detail" :description "FRB Government Check Adjustment"}
682 {:txn "DB" :level "Detail" :description "FRB Postal Money Order Debit"}
683 {:txn "DB" :level "Detail" :description "FRB Postal Money Order Adjustment"}
684 {:txn "DB" :level "Detail" :description "FRB Cash Letter Auto Charge Debit"}
685 {:txn "DB" :level "Summary" :description "Total Universal Debits"}
686 {:txn "DB" :level "Detail" :description "FRB Cash Letter Auto Charge Adjustment"}
687 {:txn "DB" :level "Detail" :description "FRB Fine-Sort Cash Letter Debit"}
688 {:txn "DB" :level "Detail" :description "FRB Fine-Sort Adjustment"}
689 {:txn "DB" :level "Summary" :description "FRB Freight Payment Debits"}
690 {:txn "DB" :level "Summary" :description "Total Miscellaneous Debits"}
691 {:txn "DB" :level "Detail" :description "Universal Debit"}
692 {:txn "DB" :level "Detail" :description "Freight Payment Debit"}
693 {:txn "DB" :level "Detail" :description "Itemized Debit Over $10,000"}
694 {:txn "DB" :level "Detail" :description "Deposit Reversal"}
695 {:txn "DB" :level "Detail" :description "Deposit Correction Debit"}
696 {:txn "DB" :level "Detail" :description "Regular Collection Debit"}
697 {:txn "DB" :level "Detail" :description "Cumulative** Debits"}
698 {:txn "DB" :level "Detail" :description "Miscellaneous Fees"}
699 {:txn "DB" :level "Detail" :description "Miscellaneous Debit"}

; {:txn "Loan" :level "Transactions-" :description "Related Type Codes"}
701 {:txn "NA" :level "Status" :description "Principal Loan Balance"}
703 {:txn "NA" :level "Status" :description "Available Commitment Amount"}
705 {:txn "NA" :level "Status" :description "Payment Amount Due"}
707 {:txn "NA" :level "Status" :description "Principal Amount Past Due"}
709 {:txn "NA" :level "Status" :description "Interest Amount Past Due"}
720 {:txn "CR" :level "Summary" :description "Total Loan Payment"}
721 {:txn "CR" :level "Detail" :description "Amount Applied to Interest"}
722 {:txn "CR" :level "Detail" :description "Amount Applied to Principal"}
723 {:txn "CR" :level "Detail" :description "Amount Applied to Escrow"}
724 {:txn "CR" :level "Detail" :description "Amount Applied to Late Charges"}
725 {:txn "CR" :level "Detail" :description "Amount Applied to Buydown"}
726 {:txn "CR" :level "Detail" :description "Amount Applied to Misc. Fees"}
727 {:txn "CR" :level "Detail" :description "Amount Applied to Deferred Interest Detail"}
728 {:txn "CR" :level "Detail" :description "Amount Applied to Service Charge"}

760 {:txn "DB" :level "Summary" :description "Loan Disbursement Non-Monetary Information"}

; Non-Monetary Information
890 {:txn "NA" :level "Detail" :description "Contains Non-monetary Information"}
})
