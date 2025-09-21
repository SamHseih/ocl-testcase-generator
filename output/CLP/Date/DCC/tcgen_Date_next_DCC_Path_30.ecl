:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_next_DCC_Path_30(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],Result = [Result_year,Result_month,Result_day],


%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
(Self_year #>= 1),
(Self_month #>= 1),
(Self_month #=< 12),
(Self_day #>= 1),
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
delay_mod(Self_year,400, Var_1579280783),
(Var_1579280783 #\= 0),
delay_mod(Self_year,4, Var_44559647),
(Var_44559647 #= 0),
delay_mod(Self_year,100, Var_1067599825),
(Var_1067599825 #= 0),
(Self_day #\= 28),
(Self_day #< 28),
(Result_year #= Self_year),
(Result_month #= Self_month),
(Result_day #= (Self_day+1)),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
