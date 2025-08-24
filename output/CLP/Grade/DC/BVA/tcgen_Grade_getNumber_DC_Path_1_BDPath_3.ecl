:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Grade_getNumber_DC_Path_1_BDPath_3(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],


%CLG Path Constrints,
((Self_number #> 0) , (Self_number #< 100)),
(Result #= Self_number),

%TypeVar Labeling Parts
labeling_int([Self_number]).
