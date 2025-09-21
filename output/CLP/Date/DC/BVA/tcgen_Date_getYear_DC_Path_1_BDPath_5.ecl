:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_1_BDPath_5(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)),
(((((((((Self_year #< 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_690339675),
delay_mod(Self_year,4, Var_1896828359),
delay_mod(Self_year,400, Var_536122141),
((Var_536122141 #= 0) ; ((Var_1896828359 #= 0) , (Var_690339675 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1709804316),
delay_mod(Self_year,4, Var_1630678941),
delay_mod(Self_year,100, Var_1792550665),
delay_mod(Self_year,4, Var_1359953204),
delay_mod(Self_year,400, Var_2014838114),
((Var_2014838114 #\= 0) , (((Var_1359953204 #\= 0) , (Var_1792550665 #\= 0)) ; ((Var_1630678941 #= 0) , (Var_1709804316 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #> 1) , (Self_month #< 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_718187988),
delay_mod(Self_year,4, Var_615438348),
delay_mod(Self_year,400, Var_978508707),
((Var_978508707 #= 0) ; ((Var_615438348 #= 0) , (Var_718187988 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_710708543),
delay_mod(Self_year,4, Var_1965237677),
delay_mod(Self_year,100, Var_664792509),
delay_mod(Self_year,4, Var_188523822),
delay_mod(Self_year,400, Var_1170727939),
((Var_1170727939 #\= 0) , (((Var_188523822 #\= 0) , (Var_664792509 #\= 0)) ; ((Var_1965237677 #= 0) , (Var_710708543 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #> 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_195228908),
delay_mod(Self_year,4, Var_471579726),
delay_mod(Self_year,400, Var_1442726378),
((Var_1442726378 #= 0) ; ((Var_471579726 #= 0) , (Var_195228908 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_16503286),
delay_mod(Self_year,4, Var_484589713),
delay_mod(Self_year,100, Var_1574598287),
delay_mod(Self_year,4, Var_2056031695),
delay_mod(Self_year,400, Var_606508809),
((Var_606508809 #\= 0) , (((Var_2056031695 #\= 0) , (Var_1574598287 #\= 0)) ; ((Var_484589713 #= 0) , (Var_16503286 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_198099809),
delay_mod(Self_year,4, Var_645482568),
delay_mod(Self_year,400, Var_807752428),
((Var_807752428 #= 0) ; ((Var_645482568 #= 0) , (Var_198099809 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1026055550),
delay_mod(Self_year,4, Var_1073763441),
delay_mod(Self_year,100, Var_752316209),
delay_mod(Self_year,4, Var_914356853),
delay_mod(Self_year,400, Var_1229161065),
((Var_1229161065 #\= 0) , (((Var_914356853 #\= 0) , (Var_752316209 #\= 0)) ; ((Var_1073763441 #= 0) , (Var_1026055550 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_428566321),
delay_mod(Self_year,4, Var_2087258327),
delay_mod(Self_year,400, Var_1016550616),
((Var_1016550616 #= 0) ; ((Var_2087258327 #= 0) , (Var_428566321 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1006094903),
delay_mod(Self_year,4, Var_2030538903),
delay_mod(Self_year,100, Var_1293680848),
delay_mod(Self_year,4, Var_1261153343),
delay_mod(Self_year,400, Var_1309176095),
((Var_1309176095 #\= 0) , (((Var_1261153343 #\= 0) , (Var_1293680848 #\= 0)) ; ((Var_2030538903 #= 0) , (Var_1006094903 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
