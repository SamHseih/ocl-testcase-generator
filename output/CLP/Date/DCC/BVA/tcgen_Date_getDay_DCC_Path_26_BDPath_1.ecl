:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getDay_DCC_Path_26_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%domiain for int Type
[Self_year, Self_month, Self_day]#::(-32768)..32767,
%CLG Path Constrints,
(Self_year #= 1),
(Self_month #>= 1),
(Self_month #=< 12),
(Self_day #>= 1),
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
(Self_month #= 11),
(Self_day #> 30),
Result = 'DateErrorException',

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
