:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_1_BDPath_5(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)),
(((((((((Self_year #< 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_844112759),
delay_mod(Self_year,4, Var_739973450),
delay_mod(Self_year,400, Var_1304117943),
((Var_1304117943 #= 0) ; ((Var_739973450 #= 0) , (Var_844112759 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1727361096),
delay_mod(Self_year,4, Var_1426963578),
delay_mod(Self_year,100, Var_556281560),
delay_mod(Self_year,4, Var_915500720),
delay_mod(Self_year,400, Var_2074820378),
((Var_2074820378 #\= 0) , (((Var_915500720 #\= 0) , (Var_556281560 #\= 0)) ; ((Var_1426963578 #= 0) , (Var_1727361096 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #> 1) , (Self_month #< 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1406014249),
delay_mod(Self_year,4, Var_829149076),
delay_mod(Self_year,400, Var_1678046232),
((Var_1678046232 #= 0) ; ((Var_829149076 #= 0) , (Var_1406014249 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1041365481),
delay_mod(Self_year,4, Var_501609049),
delay_mod(Self_year,100, Var_1922930974),
delay_mod(Self_year,4, Var_838473569),
delay_mod(Self_year,400, Var_9797126),
((Var_9797126 #\= 0) , (((Var_838473569 #\= 0) , (Var_1922930974 #\= 0)) ; ((Var_501609049 #= 0) , (Var_1041365481 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #> 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_782505238),
delay_mod(Self_year,4, Var_977552154),
delay_mod(Self_year,400, Var_1014982340),
((Var_1014982340 #= 0) ; ((Var_977552154 #= 0) , (Var_782505238 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_424398527),
delay_mod(Self_year,4, Var_390689829),
delay_mod(Self_year,100, Var_252553541),
delay_mod(Self_year,4, Var_1208203046),
delay_mod(Self_year,400, Var_268084911),
((Var_268084911 #\= 0) , (((Var_1208203046 #\= 0) , (Var_252553541 #\= 0)) ; ((Var_390689829 #= 0) , (Var_424398527 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2087785333),
delay_mod(Self_year,4, Var_1473205473),
delay_mod(Self_year,400, Var_1526970878),
((Var_1526970878 #= 0) ; ((Var_1473205473 #= 0) , (Var_2087785333 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_936653983),
delay_mod(Self_year,4, Var_1128948651),
delay_mod(Self_year,100, Var_1846501247),
delay_mod(Self_year,4, Var_671471369),
delay_mod(Self_year,400, Var_1055096410),
((Var_1055096410 #\= 0) , (((Var_671471369 #\= 0) , (Var_1846501247 #\= 0)) ; ((Var_1128948651 #= 0) , (Var_936653983 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #> 1) , (Self_month #> 1)) , (Self_month #< 12)) , (Self_day #> 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_875313400),
delay_mod(Self_year,4, Var_210281271),
delay_mod(Self_year,400, Var_1560940633),
((Var_1560940633 #= 0) ; ((Var_210281271 #= 0) , (Var_875313400 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1213818572),
delay_mod(Self_year,4, Var_501705927),
delay_mod(Self_year,100, Var_1421866327),
delay_mod(Self_year,4, Var_1497018177),
delay_mod(Self_year,400, Var_1515638188),
((Var_1515638188 #\= 0) , (((Var_1497018177 #\= 0) , (Var_1421866327 #\= 0)) ; ((Var_501705927 #= 0) , (Var_1213818572 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
