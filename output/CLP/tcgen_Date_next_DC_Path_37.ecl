:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Date_next_DC_Path_37(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],Result = [Result_year,Result_month,Result_day],


%CLG Path Constrints,
((((((Self_year #>= 1),
(Self_year #=< 3999)),
(Self_month #>= 1)),
(Self_month #=< 12)),
(Self_day #=< 31)),
(Self_day #>= 1)),
((((((Self_year #>= 1),
(Self_year #=< 3999)),
(Self_month #>= 1)),
(Self_month #=< 12)),
(Self_day #>= 1))),
(((((((Self_month #\= 1),
(Self_month #\= 3)),
(Self_month #\= 5)),
(Self_month #\= 7)),
(Self_month #\= 8)),
(Self_month #\= 10)),
(Self_month #\= 12)),
((((Self_month #\= 4),
(Self_month #\= 6)),
(Self_month #\= 9)),
(Self_month #\= 11)),
delay_mod(Year,100, Var_502800944),
delay_mod(Year,4, Var_576936864),
delay_mod(Year,400, Var_331418503),
(((Var_331418503 #= 0) ; (Var_576936864 #= 0)),
(Var_502800944 #\= 0)),
(Self_day #=< 29),
(Self_month #\= 12),
((((((Self_month #\= 1),
(Self_month #\= 3)),
(Self_month #\= 5)),
(Self_month #\= 7)),
(Self_month #\= 8)),
(Self_month #\= 10)),
((((Self_month #\= 4),
(Self_month #\= 6)),
(Self_month #\= 9)),
(Self_month #\= 11)),
delay_mod(Year,100, Var_1891502635),
delay_mod(Year,4, Var_557023567),
delay_mod(Year,400, Var_1276504061),
(((Var_1276504061 #\= 0),
(Var_557023567 #\= 0)) ; (Var_1891502635 #= 0)),
(Self_day #\= 28),
(((Result_year #= Self_year),
(Result_month #= Self_month)),
(Result_day #= (Self_day+1))),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
