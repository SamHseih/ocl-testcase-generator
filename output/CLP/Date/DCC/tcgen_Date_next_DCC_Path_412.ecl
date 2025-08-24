:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_next_DCC_Path_412(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],Result = [Result_year,Result_month,Result_day],


%CLG Path Constrints,
(Self_year #>= 1),
(Self_month #>= 1),
(Self_month #=< 12),
(Self_day #>= 1),
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
delay_mod(Self_year,400, Var_2145970759),
(Var_2145970759 #= 0),
(Self_day #=< 29),
(Self_month #\= 12),
(Self_month #\= 1),
(Self_month #\= 3),
(Self_month #\= 5),
(Self_month #\= 7),
(Self_month #\= 8),
(Self_month #\= 10),
(Self_month #\= 4),
(Self_month #\= 6),
(Self_month #\= 9),
(Self_month #\= 11),
delay_mod(Self_year,400, Var_1559122513),
(Var_1559122513 #= 0),
(Self_day #\= 29),
(Result_year #= Self_year),
(Result_month #= Self_month),
(Result_day #= (Self_day+1)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
