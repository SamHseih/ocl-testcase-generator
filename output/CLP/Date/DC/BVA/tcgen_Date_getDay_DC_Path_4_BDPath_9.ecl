:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_4_BDPath_9(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_2139788441),
delay_mod(Self_year,4, Var_1564698139),
delay_mod(Self_year,400, Var_304715920),
((Var_304715920 #= 0) ; ((Var_1564698139 #= 0) , (Var_2139788441 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_800735172),
delay_mod(Self_year,4, Var_79644918),
delay_mod(Self_year,100, Var_1107985860),
delay_mod(Self_year,4, Var_473524237),
delay_mod(Self_year,400, Var_1652764753),
((Var_1652764753 #\= 0) , (((Var_473524237 #\= 0) , (Var_1107985860 #\= 0)) ; ((Var_79644918 #= 0) , (Var_800735172 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_478489615),
delay_mod(Self_year,4, Var_171421438),
delay_mod(Self_year,400, Var_1570358965),
((Var_1570358965 #= 0) ; ((Var_171421438 #= 0) , (Var_478489615 #\= 0))),
(Self_day #= 29),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
