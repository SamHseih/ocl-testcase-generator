:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_1_BDPath_2(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2068598972),
delay_mod(Self_year,4, Var_1485089044),
delay_mod(Self_year,400, Var_84113572),
((Var_84113572 #= 0) ; ((Var_1485089044 #= 0) , (Var_2068598972 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1626343059),
delay_mod(Self_year,4, Var_2032169857),
delay_mod(Self_year,100, Var_76659128),
delay_mod(Self_year,4, Var_441001942),
delay_mod(Self_year,400, Var_2053996178),
((Var_2053996178 #\= 0) , (((Var_441001942 #\= 0) , (Var_76659128 #\= 0)) ; ((Var_2032169857 #= 0) , (Var_1626343059 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_231202600),
delay_mod(Self_year,4, Var_821576394),
delay_mod(Self_year,400, Var_1774720883),
((Var_1774720883 #= 0) ; ((Var_821576394 #= 0) , (Var_231202600 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1293203138),
delay_mod(Self_year,4, Var_2123960023),
delay_mod(Self_year,100, Var_201719260),
delay_mod(Self_year,4, Var_635371680),
delay_mod(Self_year,400, Var_1293226111),
((Var_1293226111 #\= 0) , (((Var_635371680 #\= 0) , (Var_201719260 #\= 0)) ; ((Var_2123960023 #= 0) , (Var_1293203138 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_871160466),
delay_mod(Self_year,4, Var_352083716),
delay_mod(Self_year,400, Var_1848125895),
((Var_1848125895 #= 0) ; ((Var_352083716 #= 0) , (Var_871160466 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1072377306),
delay_mod(Self_year,4, Var_1787189503),
delay_mod(Self_year,100, Var_477376212),
delay_mod(Self_year,4, Var_859654796),
delay_mod(Self_year,400, Var_1440621772),
((Var_1440621772 #\= 0) , (((Var_859654796 #\= 0) , (Var_477376212 #\= 0)) ; ((Var_1787189503 #= 0) , (Var_1072377306 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1471948789),
delay_mod(Self_year,4, Var_1605851606),
delay_mod(Self_year,400, Var_1267556427),
((Var_1267556427 #= 0) ; ((Var_1605851606 #= 0) , (Var_1471948789 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_1585239756),
delay_mod(Self_year,4, Var_1758056825),
delay_mod(Self_year,100, Var_223693919),
delay_mod(Self_year,4, Var_771418758),
delay_mod(Self_year,400, Var_361268035),
((Var_361268035 #\= 0) , (((Var_771418758 #\= 0) , (Var_223693919 #\= 0)) ; ((Var_1758056825 #= 0) , (Var_1585239756 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_648786246),
delay_mod(Self_year,4, Var_120360571),
delay_mod(Self_year,400, Var_1710814638),
((Var_1710814638 #= 0) ; ((Var_120360571 #= 0) , (Var_648786246 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1125964210),
delay_mod(Self_year,4, Var_944140566),
delay_mod(Self_year,100, Var_1534754611),
delay_mod(Self_year,4, Var_2030937207),
delay_mod(Self_year,400, Var_1551446957),
((Var_1551446957 #\= 0) , (((Var_2030937207 #\= 0) , (Var_1534754611 #\= 0)) ; ((Var_944140566 #= 0) , (Var_1125964210 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
