:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_1_BDPath_3(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #= 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2129442232),
delay_mod(Self_year,4, Var_308433917),
delay_mod(Self_year,400, Var_1473981203),
((Var_1473981203 #= 0) ; ((Var_308433917 #= 0) , (Var_2129442232 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1197251633),
delay_mod(Self_year,4, Var_1552326679),
delay_mod(Self_year,100, Var_1551629761),
delay_mod(Self_year,4, Var_1383519982),
delay_mod(Self_year,400, Var_1902671237),
((Var_1902671237 #\= 0) , (((Var_1383519982 #\= 0) , (Var_1551629761 #\= 0)) ; ((Var_1552326679 #= 0) , (Var_1197251633 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_643290333),
delay_mod(Self_year,4, Var_1396721535),
delay_mod(Self_year,400, Var_1204481453),
((Var_1204481453 #= 0) ; ((Var_1396721535 #= 0) , (Var_643290333 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1899600175),
delay_mod(Self_year,4, Var_1766869737),
delay_mod(Self_year,100, Var_947553027),
delay_mod(Self_year,4, Var_684566052),
delay_mod(Self_year,400, Var_352367347),
((Var_352367347 #\= 0) , (((Var_684566052 #\= 0) , (Var_947553027 #\= 0)) ; ((Var_1766869737 #= 0) , (Var_1899600175 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_548554586),
delay_mod(Self_year,4, Var_126189538),
delay_mod(Self_year,400, Var_1863702030),
((Var_1863702030 #= 0) ; ((Var_126189538 #= 0) , (Var_548554586 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_467796378),
delay_mod(Self_year,4, Var_702025003),
delay_mod(Self_year,100, Var_93199773),
delay_mod(Self_year,4, Var_1147805316),
delay_mod(Self_year,400, Var_1326393666),
((Var_1326393666 #\= 0) , (((Var_1147805316 #\= 0) , (Var_93199773 #\= 0)) ; ((Var_702025003 #= 0) , (Var_467796378 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_125994398),
delay_mod(Self_year,4, Var_603305436),
delay_mod(Self_year,400, Var_884860061),
((Var_884860061 #= 0) ; ((Var_603305436 #= 0) , (Var_125994398 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_454884231),
delay_mod(Self_year,4, Var_136393487),
delay_mod(Self_year,100, Var_116669570),
delay_mod(Self_year,4, Var_1572256205),
delay_mod(Self_year,400, Var_554348863),
((Var_554348863 #\= 0) , (((Var_1572256205 #\= 0) , (Var_116669570 #\= 0)) ; ((Var_136393487 #= 0) , (Var_454884231 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_11249189),
delay_mod(Self_year,4, Var_159290353),
delay_mod(Self_year,400, Var_1515877023),
((Var_1515877023 #= 0) ; ((Var_159290353 #= 0) , (Var_11249189 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1263668904),
delay_mod(Self_year,4, Var_370475881),
delay_mod(Self_year,100, Var_1795816257),
delay_mod(Self_year,4, Var_1649320501),
delay_mod(Self_year,400, Var_959629210),
((Var_959629210 #\= 0) , (((Var_1649320501 #\= 0) , (Var_1795816257 #\= 0)) ; ((Var_370475881 #= 0) , (Var_1263668904 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
