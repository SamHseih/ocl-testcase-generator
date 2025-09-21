:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((((((Self_year #< 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_58940486),
delay_mod(Self_year,4, Var_501107890),
delay_mod(Self_year,400, Var_1997859171),
((Var_1997859171 #= 0) ; ((Var_501107890 #= 0) , (Var_58940486 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_550402284),
delay_mod(Self_year,4, Var_959869407),
delay_mod(Self_year,100, Var_1449263511),
delay_mod(Self_year,4, Var_116237769),
delay_mod(Self_year,400, Var_1438098656),
((Var_1438098656 #\= 0) , (((Var_116237769 #\= 0) , (Var_1449263511 #\= 0)) ; ((Var_959869407 #= 0) , (Var_550402284 #= 0)))),(Self_day #=< 28)))))))) ; (((((Self_year #>= 1) , (Self_month #< 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_384587033),
delay_mod(Self_year,4, Var_49752459),
delay_mod(Self_year,400, Var_411506101),
((Var_411506101 #= 0) ; ((Var_49752459 #= 0) , (Var_384587033 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_514455215),
delay_mod(Self_year,4, Var_1780034814),
delay_mod(Self_year,100, Var_1360657223),
delay_mod(Self_year,4, Var_1905485420),
delay_mod(Self_year,400, Var_551479935),
((Var_551479935 #\= 0) , (((Var_1905485420 #\= 0) , (Var_1360657223 #\= 0)) ; ((Var_1780034814 #= 0) , (Var_514455215 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #> 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1888442711),
delay_mod(Self_year,4, Var_1754894440),
delay_mod(Self_year,400, Var_1998767043),
((Var_1998767043 #= 0) ; ((Var_1754894440 #= 0) , (Var_1888442711 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_787738361),
delay_mod(Self_year,4, Var_607932305),
delay_mod(Self_year,100, Var_168366),
delay_mod(Self_year,4, Var_1642030774),
delay_mod(Self_year,400, Var_1357563986),
((Var_1357563986 #\= 0) , (((Var_1642030774 #\= 0) , (Var_168366 #\= 0)) ; ((Var_607932305 #= 0) , (Var_787738361 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #< 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_105374791),
delay_mod(Self_year,4, Var_1107024580),
delay_mod(Self_year,400, Var_1010856212),
((Var_1010856212 #= 0) ; ((Var_1107024580 #= 0) , (Var_105374791 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_904861801),
delay_mod(Self_year,4, Var_204715855),
delay_mod(Self_year,100, Var_318857719),
delay_mod(Self_year,4, Var_745962066),
delay_mod(Self_year,400, Var_1637290981),
((Var_1637290981 #\= 0) , (((Var_745962066 #\= 0) , (Var_318857719 #\= 0)) ; ((Var_204715855 #= 0) , (Var_904861801 #= 0)))),(Self_day #=< 28))))))))) ; (((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #> 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #> 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_835227336),
delay_mod(Self_year,4, Var_482082765),
delay_mod(Self_year,400, Var_667821226),
((Var_667821226 #= 0) ; ((Var_482082765 #= 0) , (Var_835227336 #\= 0))),(Self_day #> 29));(delay_mod(Self_year,100, Var_1209702763),
delay_mod(Self_year,4, Var_1028780142),
delay_mod(Self_year,100, Var_2128029086),
delay_mod(Self_year,4, Var_686466458),
delay_mod(Self_year,400, Var_875016237),
((Var_875016237 #\= 0) , (((Var_686466458 #\= 0) , (Var_2128029086 #\= 0)) ; ((Var_1028780142 #= 0) , (Var_1209702763 #= 0)))),(Self_day #> 28))))))))),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
