:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getYear_DC_Path_5(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)),
(((((Self_year #>= 1) , (Self_month #>= 1)) , (Self_month #=< 12)) , (Self_day #>= 1)) , true),
(((((((Self_month #\= 1) , (Self_month #\= 3)) , (Self_month #\= 5)) , (Self_month #\= 7)) , (Self_month #\= 8)) , (Self_month #\= 10)) , (Self_month #\= 12)),
((((Self_month #\= 4) , (Self_month #\= 6)) , (Self_month #\= 9)) , (Self_month #\= 11)),
delay_mod(Self_year,100, Var_871160466),
delay_mod(Self_year,4, Var_352083716),
delay_mod(Self_year,100, Var_1848125895),
delay_mod(Self_year,4, Var_1072377306),
delay_mod(Self_year,400, Var_1787189503),
((Var_1787189503 #\= 0) , (((Var_1072377306 #\= 0) , (Var_1848125895 #\= 0)) ; ((Var_352083716 #= 0) , (Var_871160466 #= 0)))),
(Self_day #=< 28),
(Result #= Self_year),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
