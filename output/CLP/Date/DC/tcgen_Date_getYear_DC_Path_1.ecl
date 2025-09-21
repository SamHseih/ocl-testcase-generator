:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1794717576),
delay_mod(Self_year,4, Var_251210093),
delay_mod(Self_year,400, Var_919112242),
((Var_919112242 #= 0) ; ((Var_251210093 #= 0) , (Var_1794717576 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_2021707251),
delay_mod(Self_year,4, Var_1541857308),
delay_mod(Self_year,100, Var_479397964),
delay_mod(Self_year,4, Var_1861781750),
delay_mod(Self_year,400, Var_283717519),
((Var_283717519 #\= 0) , (((Var_1861781750 #\= 0) , (Var_479397964 #\= 0)) ; ((Var_1541857308 #= 0) , (Var_2021707251 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1008925772),
delay_mod(Self_year,4, Var_1175259735),
delay_mod(Self_year,400, Var_1205406622),
((Var_1205406622 #= 0) ; ((Var_1175259735 #= 0) , (Var_1008925772 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_293907205),
delay_mod(Self_year,4, Var_988800485),
delay_mod(Self_year,100, Var_345902941),
delay_mod(Self_year,4, Var_454325163),
delay_mod(Self_year,400, Var_796667727),
((Var_796667727 #\= 0) , (((Var_454325163 #\= 0) , (Var_345902941 #\= 0)) ; ((Var_988800485 #= 0) , (Var_293907205 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2028017635),
delay_mod(Self_year,4, Var_782378927),
delay_mod(Self_year,400, Var_70807318),
((Var_70807318 #= 0) ; ((Var_782378927 #= 0) , (Var_2028017635 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_910091170),
delay_mod(Self_year,4, Var_1183888521),
delay_mod(Self_year,100, Var_2041605291),
delay_mod(Self_year,4, Var_1052245076),
delay_mod(Self_year,400, Var_2136288211),
((Var_2136288211 #\= 0) , (((Var_1052245076 #\= 0) , (Var_2041605291 #\= 0)) ; ((Var_1183888521 #= 0) , (Var_910091170 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2061347276),
delay_mod(Self_year,4, Var_1559122513),
delay_mod(Self_year,400, Var_1128096251),
((Var_1128096251 #= 0) ; ((Var_1559122513 #= 0) , (Var_2061347276 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1552978964),
delay_mod(Self_year,4, Var_1259652483),
delay_mod(Self_year,100, Var_1699113578),
delay_mod(Self_year,4, Var_1306324352),
delay_mod(Self_year,400, Var_355790875),
((Var_355790875 #\= 0) , (((Var_1306324352 #\= 0) , (Var_1699113578 #\= 0)) ; ((Var_1259652483 #= 0) , (Var_1552978964 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1264213713),
delay_mod(Self_year,4, Var_1506809545),
delay_mod(Self_year,400, Var_1019384604),
((Var_1019384604 #= 0) ; ((Var_1506809545 #= 0) , (Var_1264213713 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_550668305),
delay_mod(Self_year,4, Var_963110412),
delay_mod(Self_year,100, Var_1624820151),
delay_mod(Self_year,4, Var_1219161283),
delay_mod(Self_year,400, Var_2081191879),
((Var_2081191879 #\= 0) , (((Var_1219161283 #\= 0) , (Var_1624820151 #\= 0)) ; ((Var_963110412 #= 0) , (Var_550668305 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
