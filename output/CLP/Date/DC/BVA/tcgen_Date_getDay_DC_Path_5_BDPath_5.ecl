:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DC_Path_5_BDPath_5(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , true),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_1116094714),
delay_mod(Self_year,4, Var_227755469),
delay_mod(Self_year,100, Var_762384154),
delay_mod(Self_year,4, Var_690052870),
delay_mod(Self_year,400, Var_1498438472),
((Var_1498438472 #\= 0) , (((Var_690052870 #\= 0) , (Var_762384154 #\= 0)) ; ((Var_227755469 #= 0) , (Var_1116094714 #= 0)))),
(Self_day #=< 28),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
