:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DCC_Path_53_BDPath_10(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
(Self_year #> 1),
(Self_month #> 1),
(Self_month #< 12),
(Self_day #> 1),
(Self_year #> 1),
(Self_month #> 1),
(Self_month #< 12),
(Self_day #> 1),
(Self_month #\= 1),
(Self_month #\= 3),
(Self_month #\= 5),
(Self_month #\= 7),
(Self_month #\= 8),
(Self_month #\= 10),
(Self_month #\= 12),
(Self_month #\= 4),
(Self_month #\= 6),
(Self_month #\= 9),
(Self_month #\= 11),
delay_mod(Self_year,400, Var_941836856),
(Var_941836856 #\= 0),
delay_mod(Self_year,4, Var_1677458155),
(Var_1677458155 #= 0),
delay_mod(Self_year,100, Var_1613627715),
(Var_1613627715 #= 0),
(Self_day #< 28),
(Result #= Self_day),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
