:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_1_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_363509958),
delay_mod(Self_year,4, Var_865667596),
delay_mod(Self_year,400, Var_1306834002),
((Var_1306834002 #= 0) ; ((Var_865667596 #= 0) , (Var_363509958 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1354083458),
delay_mod(Self_year,4, Var_270095066),
delay_mod(Self_year,100, Var_1806431167),
delay_mod(Self_year,4, Var_50699452),
delay_mod(Self_year,400, Var_2125062626),
((Var_2125062626 #\= 0) , (((Var_50699452 #\= 0) , (Var_1806431167 #\= 0)) ; ((Var_270095066 #= 0) , (Var_1354083458 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_702061917),
delay_mod(Self_year,4, Var_890545344),
delay_mod(Self_year,400, Var_556488341),
((Var_556488341 #= 0) ; ((Var_890545344 #= 0) , (Var_702061917 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_71706941),
delay_mod(Self_year,4, Var_1771667101),
delay_mod(Self_year,100, Var_2033968586),
delay_mod(Self_year,4, Var_48208774),
delay_mod(Self_year,400, Var_929383713),
((Var_929383713 #\= 0) , (((Var_48208774 #\= 0) , (Var_2033968586 #\= 0)) ; ((Var_1771667101 #= 0) , (Var_71706941 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1832532108),
delay_mod(Self_year,4, Var_423583818),
delay_mod(Self_year,400, Var_552936351),
((Var_552936351 #= 0) ; ((Var_423583818 #= 0) , (Var_1832532108 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1471086700),
delay_mod(Self_year,4, Var_1810742349),
delay_mod(Self_year,100, Var_154319946),
delay_mod(Self_year,4, Var_13803304),
delay_mod(Self_year,400, Var_802243390),
((Var_802243390 #\= 0) , (((Var_13803304 #\= 0) , (Var_154319946 #\= 0)) ; ((Var_1810742349 #= 0) , (Var_1471086700 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1427040229),
delay_mod(Self_year,4, Var_1604002113),
delay_mod(Self_year,400, Var_38262958),
((Var_38262958 #= 0) ; ((Var_1604002113 #= 0) , (Var_1427040229 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1217875525),
delay_mod(Self_year,4, Var_1787079037),
delay_mod(Self_year,100, Var_1813187653),
delay_mod(Self_year,4, Var_1353530305),
delay_mod(Self_year,400, Var_574268151),
((Var_574268151 #\= 0) , (((Var_1353530305 #\= 0) , (Var_1813187653 #\= 0)) ; ((Var_1787079037 #= 0) , (Var_1217875525 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_460201727),
delay_mod(Self_year,4, Var_812586739),
delay_mod(Self_year,400, Var_1881901842),
((Var_1881901842 #= 0) ; ((Var_812586739 #= 0) , (Var_460201727 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_585324508),
delay_mod(Self_year,4, Var_1234250905),
delay_mod(Self_year,100, Var_16868310),
delay_mod(Self_year,4, Var_769530879),
delay_mod(Self_year,400, Var_364639279),
((Var_364639279 #\= 0) , (((Var_769530879 #\= 0) , (Var_16868310 #\= 0)) ; ((Var_1234250905 #= 0) , (Var_585324508 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
