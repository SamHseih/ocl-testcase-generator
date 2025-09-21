:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_4_BDPath_8(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #= 1)) , (((((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)) ; (Self_month #= 12)),(Self_day #=< 31));((((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),((((((Self_month #= 4) ; (Self_month #= 6)) ; (Self_month #= 9)) ; (Self_month #= 11)),(Self_day #=< 30));(((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),((delay_mod(Self_year,100, Var_1297189682),
delay_mod(Self_year,4, Var_1272123492),
delay_mod(Self_year,400, Var_238816832),
((Var_238816832 #= 0) ; ((Var_1272123492 #= 0) , (Var_1297189682 #\= 0))),(Self_day #=< 29));(delay_mod(Self_year,100, Var_849198527),
delay_mod(Self_year,4, Var_1934932165),
delay_mod(Self_year,100, Var_551016187),
delay_mod(Self_year,4, Var_1324843695),
delay_mod(Self_year,400, Var_299413131),
((Var_299413131 #\= 0) , (((Var_1324843695 #\= 0) , (Var_551016187 #\= 0)) ; ((Var_1934932165 #= 0) , (Var_849198527 #= 0)))),(Self_day #=< 28)))))))),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1201454821),
delay_mod(Self_year,4, Var_1508038883),
delay_mod(Self_year,400, Var_728943498),
((Var_728943498 #= 0) ; ((Var_1508038883 #= 0) , (Var_1201454821 #\= 0))),
(Self_day #=< 29),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
