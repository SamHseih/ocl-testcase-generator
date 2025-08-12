:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_next_DC_Path_4_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],Result = [Result_year,Result_month,Result_day],


%CLG Path Constrints,
((((Self_year #= 1),
(Self_month #>= 1)),
(Self_month #=< 12)),
(Self_day #>= 1)),
(Self_month #\= 12),
((((((Self_month #= 1) ; (Self_month #= 3)) ; (Self_month #= 5)) ; (Self_month #= 7)) ; (Self_month #= 8)) ; (Self_month #= 10)),
(Self_day #\= 31),
((((Self_day #< 31),
(Result_year #= Self_year)),
(Result_month #= Self_month)),
(Result_day #= (Self_day+1))),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
